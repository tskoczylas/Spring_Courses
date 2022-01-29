package pl.javastart.equipy.service;

import org.springframework.stereotype.Service;
import pl.javastart.equipy.entity.Category;
import pl.javastart.equipy.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {

        return categoryRepository.findAllByName(name);
    }

    @Override
    public List<String> categoryList() {
        return categoryRepository.
                findAll().
                stream().
                map(Category::getName).
                collect(Collectors.toList());
    }
}
