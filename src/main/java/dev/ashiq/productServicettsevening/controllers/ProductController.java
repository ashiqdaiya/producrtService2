package dev.ashiq.productServicettsevening.controllers;

import dev.ashiq.productServicettsevening.Exception.NotFoundException;
import dev.ashiq.productServicettsevening.dto.ProductDto;
import dev.ashiq.productServicettsevening.models.Category;
import dev.ashiq.productServicettsevening.models.Product;
import dev.ashiq.productServicettsevening.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
 //   @GetMapping
//    public List<Product> getAllProduct(){
//
//        return productService.getAllProduct();
//    }
//    @GetMapping("/{productId}")
//    public ResponseEntity<Optional<Product>> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {
//        ResponseEntity<Optional<Product>> response = new ResponseEntity<>(
//                productService.getSingleProduct(productId),
//                HttpStatus.OK
//        );

//      Optional<Product> product =response.getBody();
//
//        if(product.isEmpty()){
//            throw new NotFoundException("No product with id: "+productId);
//        }
//
//        return response;
//    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product newProduct = productService.addNewProduct(productDto);

        ResponseEntity<Product> response=new ResponseEntity<>(newProduct,HttpStatus.OK);

        return response;
    }

//    @PatchMapping ("/{productId}")
//    public Product updateProduct(@PathVariable("productId") Long productId,
//                               @RequestBody  ProductDto productDto){
//        Product product = new Product();
//        product.setId(productDto.getId());
//        product.setCategory(new Category());
//        product.getCategory().setName(String.valueOf(productDto.getCategoryDto()));
//        product.setTitle(productDto.getTitle());
//        product.setPrice(productDto.getPrice());
//        product.setDescription(productDto.getDescription());
//        return productService.updateProduct(productId,product);
//    }


}
