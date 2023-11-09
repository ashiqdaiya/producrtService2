package dev.ashiq.productServicettsevening.controllers;

import dev.ashiq.productServicettsevening.dto.ProductDto;
import dev.ashiq.productServicettsevening.models.Product;
import dev.ashiq.productServicettsevening.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products-db")
public class ProductControllerDB {

    private final ProductService productService;

    public ProductControllerDB(ProductService productService){

        this.productService=productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getSingleProduct(@PathVariable("id") Long id){
        ResponseEntity<Optional<Product>> response= new ResponseEntity<>(
           productService.getSingleProduct(id),
        HttpStatus.OK
        );
         Optional<Product> product=response.getBody();
         return response;

    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(
                productService.getAllProduct(),
                HttpStatus.OK
        );
    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        ResponseEntity<Product> response=new ResponseEntity<>(
                productService.addNewProduct(productDto),
                HttpStatus.OK
        );

      return response;

    }
    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long id,
                                                 @RequestBody ProductDto productDto){
        ResponseEntity<Product> response=new ResponseEntity<>(
                productService.updateProduct(id,productDto),
                HttpStatus.OK
        );
        return response;
    }

}
