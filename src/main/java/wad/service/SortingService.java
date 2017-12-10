
package wad.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wad.domain.Article;
import wad.domain.Category;
import wad.domain.UserSession;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;

@Service
public class SortingService {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private UserSessionService userSessionService;
    
    public void projectSortedArticles(Model model, HttpSession session, Long categoryId) {
        UserSession usession = userSessionService.getUserSession(session);
        
        Pageable pageable;
        if(usession.getByTimeOrByViews()) pageable = PageRequest.of(0, usession.getArticlesShown(), Sort.Direction.DESC, "publishingTime");
        else pageable = PageRequest.of(0, usession.getArticlesShown(), Sort.Direction.DESC, "views");
        
        if(categoryId == null) {
            model.addAttribute("articles", articleRepository.findAll(pageable));
        
        } else {
            List<Article> articles = new ArrayList();
            
            Category category = categoryRepository.getOne(categoryId);
            for (Article a : articleRepository.findAll(pageable)) {
                if(a.getCategories().contains(category)) articles.add(a);
            }
            
            model.addAttribute("articles", articles);
        }
    }
}
