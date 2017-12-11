
package wad.controller;

import java.io.IOException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Article;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;
import wad.repository.WriterRepository;

@Transactional
@Controller
public class EditController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private WriterRepository writerRepository;
    
//    @GetMapping("/edit/{articleId}")
//    public String editPage(Model model, @PathVariable Long articleId) {
//        model.addAttribute("allCategories", categoryRepository.findAll());
//        model.addAttribute("allWriters", writerRepository.findAll());
//        model.addAttribute("article", articleRepository.getOne(articleId));
//        return "edit";
//    }
    
    @PostMapping("/edit")
    public String editArticle(Article article, @RequestParam String oldName, @RequestParam("file") MultipartFile file) throws IOException {
        Boolean newPicture = (file != null && file.getContentType().contains("image"));
        article = migrateOldArticleData(article, oldName, newPicture);
        
        articleRepository.deleteByName(oldName);
        
        if(newPicture) article.setPicture(file.getBytes());
        
        article.edit();
        articleRepository.save(article);
        return "redirect:/admin";
    }
    
    public Article migrateOldArticleData(Article newArticle, String oldArticleName, Boolean newPicture) {
        Article oldArticle = articleRepository.findByName(oldArticleName);
        
        newArticle.setPublishingTime(oldArticle.getPublishingTime());
        newArticle.setViews(oldArticle.getViews());
        
        if(!newPicture) newArticle.setPicture(oldArticle.getPicture());
        
        return newArticle;
    }
}
