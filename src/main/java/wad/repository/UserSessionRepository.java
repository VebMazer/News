
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.UserSession;


public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    
}
