package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Article;
import wad.repository.ArticleRepository;

@Controller
public class DefaultController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "index";
    }
    
    @GetMapping("/edit")
    public String editPage(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String create(@RequestParam String name) {
        Article i = new Article(); // parametrit...
        articleRepository.save(i);
        return "redirect:/";
    }
}
