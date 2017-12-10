
package wad.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.UserSession;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    
}
