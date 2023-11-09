package dev.ashiq.productServicettsevening.repo;

import dev.ashiq.productServicettsevening.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
//    List<Product> findAllProduct();
    Product findProductById(Long id);


}
