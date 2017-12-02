
package wad.domain;

import java.util.TreeSet;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Writer extends AbstractPersistable<Long> {
    
    private String name;
    private TreeSet<Article> articles;
    
}
