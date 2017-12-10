
package wad.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Article;
import wad.domain.Category;
import wad.domain.UserSession;
import wad.repository.ArticleRepository;
import wad.repository.CategoryRepository;
import wad.repository.UserSessionRepository;

@Transactional
@Service
public class UserSessionService {
    
    @Autowired
    private UserSessionRepository userSessionRepository;
    
    public UserSession getUserSession(HttpSession session) {
        if(session.getAttribute("usession") != null) {
            Long id = (Long) session.getAttribute("usession");
            if(userSessionRepository.existsById(id)) {
                UserSession s = userSessionRepository.getOne(id);
                if(s.getLastVisited().plusMinutes(120).isBefore(LocalDateTime.now())) {
                    s.setDefaults();
                }
                s.setLastVisited(LocalDateTime.now());
                return s;
            }
        }
        return createUserSession(session);
    }
    
    public UserSession createUserSession(HttpSession session) {
        UserSession s = new UserSession();
        s.setName(session.getId());
        userSessionRepository.save(s);
        session.setAttribute("usession", s.getId());
        s.setDefaults();
        return s;
    }
    
    public UserSession saveUserSession(UserSession u) {
        return userSessionRepository.save(u);
    }
    
}
