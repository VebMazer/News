package wad.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Article;

@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByName(String name);
    void deleteByName(String name);
}
