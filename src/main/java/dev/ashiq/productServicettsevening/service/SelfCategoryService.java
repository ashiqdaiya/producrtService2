package dev.ashiq.productServicettsevening.service;

import dev.ashiq.productServicettsevening.models.Category;
import dev.ashiq.productServicettsevening.repo.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class SelfCategoryService implements CategoryService{

    private final CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getProductsInCategory(Long categoryId) {
        return null;
    }
}
