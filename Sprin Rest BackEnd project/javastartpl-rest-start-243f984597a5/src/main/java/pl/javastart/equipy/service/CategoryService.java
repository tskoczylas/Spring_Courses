package pl.javastart.equipy.service;

import pl.javastart.equipy.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findCategoryByName(String name);

    List<String> categoryList();
}
