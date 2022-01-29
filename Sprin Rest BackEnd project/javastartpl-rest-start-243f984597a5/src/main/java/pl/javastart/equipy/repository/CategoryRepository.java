package pl.javastart.equipy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.equipy.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {


    Optional<Category> findAllByName(String name);
}
