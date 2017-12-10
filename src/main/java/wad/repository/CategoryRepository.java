
package wad.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
