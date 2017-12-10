
package wad.domain;

import java.util.List;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Category extends AbstractPersistable<Long> {
    
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Article> articles;
    
    public void removeArticle(Article a) {
        articles.remove(a);
    }
    
    public void addArticle(Article a) {
        if(!articles.contains(a)) articles.add(a);
    }
    
}
