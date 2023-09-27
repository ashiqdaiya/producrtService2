package dev.ashiq.productServicettsevening.service;

import dev.ashiq.productServicettsevening.clients.FakeStoreProductDto;
import dev.ashiq.productServicettsevening.dto.ProductDto;
import dev.ashiq.productServicettsevening.models.Category;
import dev.ashiq.productServicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    @Override
    public List<Product> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> k= restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductDto[].class);
//        ResponseEntity<ProductDto[]> k = restTemplate.getForEntity(
//                "https://fakestoreapi.com/products",
//                ProductDto[].class
//        );

        List<Product> ans = new ArrayList<>();
        for(ProductDto productDto: k.getBody()){
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            Category category = new Category();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setImage(productDto.getImage());
            ans.add(product);
        }

        return ans;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<ProductDto> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                ProductDto.class,productId);
        ProductDto productDto= response.getBody();
        Product product= new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImage(productDto.getImage());
        return product;
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                productDto,
                ProductDto.class
        );
       // ProductDto productDto = response.getBody();
        Product product1 = new Product();
        product1.setId(productDto.getId());
        product1.setTitle(productDto.getTitle());
        product1.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product1.setCategory(category);
        product1.setImage(productDto.getImage());

        return product1;

    }

    @Override
    public Product updateProduct(Long productId,Product product) {
        RestTemplate restTemplate= restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        FakeStoreProductDto fakeStoreProductDto= new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setCategory(product.getCategory().getName());

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity= requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
//          FakeStoreProductDto fakeStoreProductDtoResponse = restTemplate.patchForObject(
//                  "https://fakestoreapi.com/products/{id}",
//                  fakeStoreProductDto,
//                  FakeStoreProductDto.class,
//                  productId
//          );

        return convertFakeStoreProductDtoToProduct((fakeStoreProductDtoResponseEntity.getBody()));
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDtoResponse) {
        Product product = new Product();
        product.setId(fakeStoreProductDtoResponse.getId());
        product.setDescription(fakeStoreProductDtoResponse.getDescription());
        product.setImage(fakeStoreProductDtoResponse.getImage());
        product.setPrice(fakeStoreProductDtoResponse.getPrice());
        product.setTitle(fakeStoreProductDtoResponse.getTitle());
        Category category = new Category();
        category.setName(fakeStoreProductDtoResponse.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public String deleteAProduct(Long productId) {
        return null;
    }
}
