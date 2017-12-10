package wad.controller;

import java.io.IOException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Article;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;
import wad.repository.WriterRepository;

@Transactional
@Controller
public class CreateController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private WriterRepository writerRepository;
    
    @GetMapping("/create")
    public String createArticle(Model model) {
        model.addAttribute("allCategories", categoryRepository.findAll());
        model.addAttribute("allWriters", writerRepository.findAll());
        model.addAttribute("article", new Article());
        return "create";
    }
    
    @PostMapping("/create")
    public String createArticle(Article article, @RequestParam("file") MultipartFile file) throws IOException {
        if(file != null && file.getContentType().contains("image")) {
            article.setPicture(file.getBytes());
        }
        article.publish();
        articleRepository.save(article);
        return "redirect:/admin";
    }
    
}
    