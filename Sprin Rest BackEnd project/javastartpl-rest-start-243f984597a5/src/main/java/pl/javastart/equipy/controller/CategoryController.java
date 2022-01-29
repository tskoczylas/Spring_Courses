package pl.javastart.equipy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javastart.equipy.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("names")
    ResponseEntity<List<String>>getCategoryList(){
        return ResponseEntity.
                ok().
                body(categoryService.categoryList());
    }






}
