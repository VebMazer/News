
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wad.domain.Article;
import wad.repository.ArticleRepository;

@Controller
public class ArticleController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @GetMapping("/articles/{articleId}")
    public String articlePage(Model model, @PathVariable Long articleId) {
        model.addAttribute("article", articleRepository.getOne(articleId));
        Article a = articleRepository.getOne(articleId);
        a.setViews(a.getViews()+1);
        articleRepository.save(a);
        return "article";
    }
    
    
}
