
package wad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Article;
import wad.domain.Category;
import wad.domain.Writer;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;
import wad.repository.WriterRepository;

@Transactional
@Controller
public class AdminController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private WriterRepository writerRepository;
    
    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("writers", writerRepository.findAll());
        return "admin";
    }
    
    @DeleteMapping("/admin/{articleId}")
    @Transactional
    public String deleteArticle(@PathVariable Long articleId) {
        Article a = articleRepository.getOne(articleId);
        
        for(Category c : categoryRepository.findAll()) {
            c.removeArticle(a);
        }
        for(Writer w : writerRepository.findAll()) {
            w.removeArticle(a);;
        }
        
        articleRepository.delete(a);
        return "redirect:/admin";
    }
    
    @DeleteMapping("/admin/{categoryId}")
    @Transactional
    public String deleteCategory(@PathVariable Long categoryId) {
        Category c = categoryRepository.getOne(categoryId);
        
        for(Article a : articleRepository.findAll()) {
            a.removeCategory(c);
        }
        
        categoryRepository.delete(c);
        return "redirect:/admin";
    }
    
    @DeleteMapping("/admin/{writerId}")
    @Transactional
    public String deleteWriter(@PathVariable Long writerId) {
        Writer w = writerRepository.getOne(writerId);
        
        for(Article a : articleRepository.findAll()) {
            a.removeWriter(w);
        }
        
        writerRepository.delete(w);
        return "redirect:/admin";
    }
    
    @PostMapping("/admin/category")
    public String createCategory(@RequestParam String name) {
        Category c = new Category();
        c.setName(name);
        categoryRepository.save(c);
        return "redirect:/admin";
    }
    
    @PostMapping("/admin/writer")
    public String createWriter(@RequestParam String name) {
        Writer w = new Writer();
        w.setName(name);
        writerRepository.save(w);
        return "redirect:/admin";
    }
    
}
