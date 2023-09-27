package dev.ashiq.productServicettsevening.service;

import dev.ashiq.productServicettsevening.dto.ProductDto;
import dev.ashiq.productServicettsevening.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {


    public List<Product> getAllProduct();

    public Product getSingleProduct(@PathVariable("productId") Long productId);

    public Product addNewProduct(ProductDto productDto);


    public Product updateProduct(@PathVariable("productId") Long productId, Product product);

    public String deleteAProduct(@PathVariable("productId") Long productId);

}
