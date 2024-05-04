package wiem.projetspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiem.projetspringboot.Model.Category;

import java.util.Optional;



    public interface CategoryRepository extends JpaRepository<Category, Integer> {

        Optional<Category> findCategoryByCode(String code);
}
