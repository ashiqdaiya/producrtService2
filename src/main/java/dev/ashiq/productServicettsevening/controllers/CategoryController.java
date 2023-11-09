package dev.ashiq.productServicettsevening.controllers;

import dev.ashiq.productServicettsevening.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ashiq.productServicettsevening.service.CategoryService;

import java.util.List;

//@RestController
//@RequestMapping("/products/categories")
//public class CategoryController {
//    private final CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService){
//        this.categoryService=categoryService;
//    }

//    @GetMapping
//    public List<Category> getAllCategories(){
//
//        return categoryService.getAllCategories();
//    }

//    @GetMapping("/{categoryId}")
//    public Category getProductsInCategory(@PathVariable("categoryId") Long categoryId){
//        return null;
//    }

//}
