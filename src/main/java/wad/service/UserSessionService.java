
package wad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Article;
import wad.domain.Category;
import wad.domain.UserSession;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;
import wad.repository.UserSessionRepository;

@Service
public class UserSessionService {
    
    @Autowired
    private UserSessionRepository userSessionRepository;
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public UserSession getUserSession(HttpSession session) {
        UserSession s;
        if(session.getAttribute("usession") == null) {
            s = new UserSession();
            s.setName(session.getId());
            userSessionRepository.save(s);
            session.setAttribute("usession", s.getId());
        } else {
            Long id = (Long) session.getAttribute("usession");
            s = userSessionRepository.getOne(id);
        }
        return s;
    }
    
    public List<Article> chosenArticles(UserSession s) {
        if(s.NothingSelected()) return articleRepository.findAll();
        
        TreeSet<Article> set = new TreeSet<>();
        for (Category c : s.getSearchCategories()) {
            set.addAll(categoryRepository.getOne(c.getId()).getArticles());
        }
        
        List<Article> articles = new ArrayList<>();
        for (Article a : set) {
            articles.add(a);
        }
        
        return articles;
    }
    
}
