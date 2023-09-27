package dev.ashiq.productServicettsevening.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {


    public String getAllCategories();


    public String getProductsInCategory(@PathVariable("categoryId") Long categoryId);
}
