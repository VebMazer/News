package wad.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Article extends AbstractPersistable<Long> {

    private String name;
    private String lead;
    private String text;
    
    private LocalDateTime publishingTime;
    private LocalDateTime lastEditTime;
    private boolean edited;
    private int views;
    
    //@Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] picture;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Writer> writers;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;
    
    public void publish() {
        this.publishingTime = LocalDateTime.now();
        this.lastEditTime = LocalDateTime.now();
    }
    
    public void edit() {
        this.edited = true;
        this.lastEditTime = LocalDateTime.now();
    }
    
    public List<Writer> getWriters() {
        if(writers == null) writers = new ArrayList<>();
        return writers;
    }
    
    public List<Category> getCategories() {
        if(categories == null) categories = new ArrayList<>();
        return categories;
    }
    
    public void removeCategory(Category c) {
        categories.remove(c);
    }
    
    public void removeWriter(Writer w) {
        writers.remove(w);
    }
    
    public void addCategory(Category c) {
        if(!categories.contains(c)) categories.add(c);
    }
    
    public void addWriter(Writer w) {
        if(!writers.contains(w)) writers.add(w);
    }
    
}
