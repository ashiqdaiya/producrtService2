package dev.ashiq.productServicettsevening.controllers;

import dev.ashiq.productServicettsevening.clients.authenticationclient.AuthenticationClient;
import dev.ashiq.productServicettsevening.dto.ProductDto;
import dev.ashiq.productServicettsevening.dto.ProductRequestDto;
import dev.ashiq.productServicettsevening.models.Product;
import dev.ashiq.productServicettsevening.repo.ProductRepository;
import dev.ashiq.productServicettsevening.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products-db")
public class ProductControllerDB {

    private final ProductService productService;

    private final ProductRepository productRepository;

    private final AuthenticationClient authenticationClient;

    public ProductControllerDB(ProductService productService,ProductRepository productRepository,
                               AuthenticationClient authenticationClient){
        this.productService=productService;
        this.productRepository=productRepository;
        this.authenticationClient=authenticationClient;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getSingleProduct(@Nullable @RequestHeader("AUTH_TOKEN") String token,
                                                              @Nullable @RequestHeader("USER_ID") Long userId,
                                                                  @PathVariable("id") Long id){
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//
//        headers.add(
//                "auth-token", "noaccess4uheyhey"
//        );
        ResponseEntity<Optional<Product>> response= new ResponseEntity<>(
           productService.getSingleProduct(id),
        HttpStatus.OK
        );
         Optional<Product> product=response.getBody();
         return response;

    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<Product>> getProduct(@RequestBody ProductRequestDto request){
        return ResponseEntity.of(Optional.ofNullable(productService.getProducts(request.getNumberOfResults(),
                request.getOffset()
        )));
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(@Nullable @RequestHeader("AUTH_TOKEN") String token
                                                       ){
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
