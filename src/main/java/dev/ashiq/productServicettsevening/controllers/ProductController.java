package dev.ashiq.productServicettsevening.controllers;

import dev.ashiq.productServicettsevening.dto.ProductDto;
import dev.ashiq.productServicettsevening.models.Category;
import dev.ashiq.productServicettsevening.models.Product;
import dev.ashiq.productServicettsevening.service.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public List<Product> getAllProduct(){

        return productService.getAllProduct();
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){

        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.getSingleProduct(productId),
                        HttpStatus.OK
        );
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product newProduct = productService.addNewProduct(productDto);

        ResponseEntity<Product> response=new ResponseEntity<>(newProduct,HttpStatus.OK);

        return response;
    }

    @PatchMapping ("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return productService.updateProduct(productId,product);
    }
    @DeleteMapping("/{productId}")
    public String deleteAProduct(@PathVariable("productId") Long productId){
        return "product deleted";
    }

}
