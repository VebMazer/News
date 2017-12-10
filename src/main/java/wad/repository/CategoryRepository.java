
package wad.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Category;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
