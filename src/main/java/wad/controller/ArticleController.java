
package wad.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.domain.Article;
import wad.repository.ArticleRepository;

@Transactional
@Controller
public class ArticleController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @GetMapping("/articles/{articleId}")
    public String articlePage(Model model, @PathVariable Long articleId) {
        Article a = articleRepository.getOne(articleId);
        a.setViews(a.getViews()+1);
        model.addAttribute("article", a);
        articleRepository.save(a);
        return "article";
    }
    
    @GetMapping(path = "/articles/{articleId}/picture")
    @ResponseBody
    public byte[] get(@PathVariable Long articleId) {
        return articleRepository.getOne(articleId).getPicture();
    }
}
