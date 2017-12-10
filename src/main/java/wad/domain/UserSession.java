
package wad.domain;

import java.time.LocalDateTime;
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
public class UserSession  extends AbstractPersistable<Long> {
    
    private String name;
    private Boolean byTimeOrByViews; //byTime: true, byViews: false
    private String byTimeOrByViewsString;
    private Integer articlesShown;
    private String currentPath;
    private LocalDateTime lastVisited;
    
    public void setDefaults() {
        setByTimeOrByViews(true);
        articlesShown = 5;
        currentPath = "/";
        lastVisited = LocalDateTime.now();
    }
    
    public void setByTimeOrByViews(Boolean byTimeOrByViews) {
        if(byTimeOrByViews) byTimeOrByViewsString = "Most Popular";
        else byTimeOrByViewsString = "Most recent";
        this.byTimeOrByViews = byTimeOrByViews;
    }
}
