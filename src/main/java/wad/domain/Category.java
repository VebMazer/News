
package wad.domain;

import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Category extends AbstractPersistable<Long> {
    
    private String name;
    
    @ManyToMany() //Lisää eager
    private TreeSet<Article> articles;
}
