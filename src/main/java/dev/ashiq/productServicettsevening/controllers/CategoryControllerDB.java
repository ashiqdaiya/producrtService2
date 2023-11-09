package dev.ashiq.productServicettsevening.controllers;

import dev.ashiq.productServicettsevening.models.Category;
import dev.ashiq.productServicettsevening.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryControllerDB {

    private CategoryService categoryService;

    public CategoryControllerDB(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){

        return new ResponseEntity<List<Category>>(
                categoryService.getAllCategories(),
                HttpStatus.OK
        );

    }
}
