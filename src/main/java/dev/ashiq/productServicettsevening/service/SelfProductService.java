package dev.ashiq.productServicettsevening.service;

import dev.ashiq.productServicettsevening.dto.CategoryDto;
import dev.ashiq.productServicettsevening.dto.ProductDto;
import dev.ashiq.productServicettsevening.models.Category;
import dev.ashiq.productServicettsevening.models.Product;
import dev.ashiq.productServicettsevening.repo.CategoryRepository;
import dev.ashiq.productServicettsevening.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Primary
public class SelfProductService implements ProductService{

   private ProductRepository productRepo;
   // private final CategoryRepository categoryRepository;

    @Autowired
   public SelfProductService(ProductRepository productRepo
                             ){
       this.productRepo=productRepo;
       // this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        Product product=productRepo.findProductById(productId);
        return Optional.ofNullable(product);
    }

    @Override
    public Page<Product> getProducts(int numberOfProducts, int offset) {
        Page<Product> products= productRepo.findAll(
                PageRequest.of((offset/numberOfProducts),
                        numberOfProducts, Sort.by("price")
                                .descending()
                                .and(
                                      Sort.by("title").ascending()
                                ))
        );
        return products;
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
       Product product=ConvertProductDtoToProduct(productDto);
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto product) {
        Product product1 = productRepo.getReferenceById(productId);
        product1.setTitle(product.getTitle());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setImage(product.getDescription());
//        Category category = new Category();
//        category.setName(product.getCategoryDto().getName());
//        category.setDescription(product.getCategoryDto().getDescription());
//        product1.setCategory(category);
        return productRepo.save(product1);
    }
    public Product ConvertProductDtoToProduct(ProductDto productDto){
        Product product = new Product();
        product.setDescription(productDto.getDescription());

        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = new Category();
        category.setName(productDto.getCategoryDto().getName());
        category.setDescription(productDto.getCategoryDto().getDescription());
        product.setCategory(category);
        return product;
    }
}
