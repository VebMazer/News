
package wad.controller;

import java.io.IOException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Article;
import wad.domain.Category;
import wad.domain.Writer;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;
import wad.repository.WriterRepository;

@Controller
public class EditController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private WriterRepository writerRepository;
    
    @GetMapping("/edit/{articleId}")
    public String editPage(Model model, @PathVariable Long articleId) {
        model.addAttribute("article", articleRepository.getOne(articleId));
        return "edit";
    }
    
    @PostMapping("/edit/{articleId}/name")
    public String changeName(@PathVariable Long articleId, @RequestParam String name) {
        Article a = articleRepository.getOne(articleId);
        a.setName(name);
        a.edit();
        articleRepository.save(a);
        return "redirect:/edit/{articleId}";
    }
    
    @PostMapping("/edit/{articleId}/lead")
    public String changeLead(@PathVariable Long articleId, @RequestParam String lead) {
        Article a = articleRepository.getOne(articleId);
        a.setLead(lead);
        a.edit();
        articleRepository.save(a);
        return "redirect:/edit/{articleId}";
    }
    
    @PostMapping("/edit/{articleId}/text")
    public String changeText(@PathVariable Long articleId, @RequestParam String text) {
        Article a = articleRepository.getOne(articleId);
        a.setText(text);
        a.edit();
        articleRepository.save(a);
        return "redirect:/edit/{articleId}";
    }
    
    @PostMapping("/edit/{articleId}/picture")
    public String changePicture(@PathVariable Long articleId, @RequestParam("file") MultipartFile file) throws IOException{
        if(file.getContentType().contains("image")) {
            Article a = articleRepository.getOne(articleId);
            a.setPicture(file.getBytes());
            a.edit();
            articleRepository.save(a);
        }
        return "redirect:/edit/{articleId}";
    }
    
    @PostMapping("/edit/{articleId}/category")
    @Transactional
    public String addCategory(@PathVariable Long articleId, @RequestParam Long categoryId) {
        Article a = articleRepository.getOne(articleId);
        Category c = categoryRepository.getOne(categoryId);
        a.addCategory(c);
        c.addArticle(a);
        a.edit();
        return "redirect:/edit/{articleId}";
    }
    
    @PostMapping("/edit/{articleId}/writer")
    @Transactional
    public String addWriter(@PathVariable Long articleId, @RequestParam Long writerId) {
        Article a = articleRepository.getOne(articleId);
        Writer w = writerRepository.getOne(writerId);
        a.addWriter(w);
        w.addArticle(a);
        a.edit();
        return "redirect:/edit/{articleId}";
    }
    
    @DeleteMapping("/edit/{articleId}/category")
    @Transactional
    public String removeCategoryRelation(@PathVariable Long articleId, @RequestParam Long categoryId) {
        Article a = articleRepository.getOne(articleId);
        Category c = categoryRepository.getOne(categoryId);
        a.removeCategory(c);
        c.removeArticle(a);
        a.edit();
        return "redirect:/edit/{articleId}";
    }
    
    @DeleteMapping("/edit/{articleId}/writer")
    @Transactional
    public String removeWriterRelation(@PathVariable Long articleId, @RequestParam Long writerId) {
        Article a = articleRepository.getOne(articleId);
        Writer w = writerRepository.getOne(writerId);
        a.removeWriter(w);
        w.removeArticle(a);
        a.edit();
        return "redirect:/edit/{articleId}";
    }
    
}
