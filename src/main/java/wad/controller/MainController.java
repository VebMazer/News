package wad.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Article;
import wad.domain.UserSession;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;
import wad.service.UserSessionService;

@Controller
public class MainController {

    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private UserSessionService userSessionService;
    
    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        UserSession currentSession = userSessionService.getUserSession(session);
        
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("articles", userSessionService.chosenArticles(currentSession));
        //Sorting still needs to be added for based on lastweeksviews
        //and publishing time.
        return "index";
    }
    
    @GetMapping("/{categoryId}")
    public String categoryArticles(Model model, @PathVariable Long categoryId) {
        model.addAttribute("articles", categoryRepository.getOne(categoryId).getArticles());
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
    
    


}
