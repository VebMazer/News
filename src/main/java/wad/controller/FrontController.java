package wad.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.UserSession;
import wad.repository.CategoryRepository;
import wad.service.*;

@Transactional
@Controller
public class FrontController {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private UserSessionService userSessionService;
    
    @Autowired
    private SortingService sortingService;
    
    
    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        model.addAttribute("categories", categoryRepository.findAll());
        UserSession usession = userSessionService.getUserSession(session);
        sortingService.projectSortedArticles(model, session, null);
        usession.setCurrentPath("/");
        model.addAttribute("usession", usession);
        return "front";
    }
    
    @GetMapping("/front/{categoryId}")
    public String categoryArticles(Model model, HttpSession session, @PathVariable Long categoryId) {
        model.addAttribute("categories", categoryRepository.findAll());
        UserSession usession = userSessionService.getUserSession(session);
        sortingService.projectSortedArticles(model, session, categoryId);
        usession.setCurrentPath("/front/" + categoryId);
        model.addAttribute("usession", usession);
        return "front";
    }
    
    @PostMapping("/config/amountOfArticlesShown")
    public String changeArticlesShown(@RequestParam String howMany, HttpSession session) {
        UserSession usession = userSessionService.getUserSession(session);
        try {
            usession.setArticlesShown(Integer.parseInt(howMany));
        } catch(Exception e) {
            usession.setArticlesShown(5);
        }
        return "redirect:" + usession.getCurrentPath();
    }
    
    @PostMapping("/config/sortByTimeOrViews")
    public String views(HttpSession session) {
        UserSession usession = userSessionService.getUserSession(session);
        usession.setByTimeOrByViews(!usession.getByTimeOrByViews());
        return "redirect:" + usession.getCurrentPath();
    }
    
}
