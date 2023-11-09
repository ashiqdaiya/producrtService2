package dev.ashiq.productServicettsevening.repo;

import dev.ashiq.productServicettsevening.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category save(Category category);



  //  Category getAllCategories();
//String saveCategory(String name);

}
