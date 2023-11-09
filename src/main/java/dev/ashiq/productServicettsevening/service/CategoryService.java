package dev.ashiq.productServicettsevening.service;

import dev.ashiq.productServicettsevening.models.Category;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {


    public List<Category> getAllCategories();


    public Category getProductsInCategory(@PathVariable("categoryId") Long categoryId);
}
