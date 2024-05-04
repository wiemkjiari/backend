package wiem.projetspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findArticleByCodeArticle(String codeArticle);

    List<Article> findAllByCategoryId(Integer idCategory);
}
