
package wad.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Writer;

public interface WriterRepository extends JpaRepository<Writer, Long> {
    
}
