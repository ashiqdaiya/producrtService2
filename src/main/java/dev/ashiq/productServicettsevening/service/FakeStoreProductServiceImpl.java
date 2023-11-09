package dev.ashiq.productServicettsevening.service;

import dev.ashiq.productServicettsevening.clients.FakeStoreClient;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


//public class FakeStoreProductServiceImpl implements ProductService{
//
//    private RestTemplateBuilder restTemplateBuilder;
//    private FakeStoreClient fakeStoreClient;
//
//    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient){
//        this.restTemplateBuilder=restTemplateBuilder;
//        this.fakeStoreClient=fakeStoreClient;
//    }
//
////    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
////                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
////        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
////                HttpComponentsClientHttpRequestFactory.class
////        ).build();
////
////        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
////        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
////        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
////    }
//    @Override
//    public List<Product> getAllProduct() {
//        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProduct();
//
//
//        List<Product> ans = new ArrayList<>();
//        for(FakeStoreProductDto productDto: fakeStoreProductDtos){
//          ans.add(convertFakeStoreProductDtoToProduct(productDto));
//        }
//
//        return ans;
//    }
//
//    @Override
//    public Optional<Product> getSingleProduct(Long productId) {
//       FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getSingleProduct(productId);
//         if(fakeStoreProductDto==null){
//             return Optional.empty();
//         }
//
//        return (Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto)));
//    }
//
//    @Override
//    public Product addNewProduct(ProductDto productDto) {
//
//        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.addNewProduct(productDto);
//
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
//
//    }
//
//    @Override
//    public Product updateProduct(Long productId, Product product) {
//
//
//        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.updateProduct(productId,product);
//
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
//    }
//
//    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDtoResponse) {
//        Product product = new Product();
//        product.setId(fakeStoreProductDtoResponse.getId());
//        product.setDescription(fakeStoreProductDtoResponse.getDescription());
//        product.setImage(fakeStoreProductDtoResponse.getImage());
//        product.setPrice(fakeStoreProductDtoResponse.getPrice());
//        product.setTitle(fakeStoreProductDtoResponse.getTitle());
//        Category category = new Category();
//        category.setName(fakeStoreProductDtoResponse.getCategory());
//        product.setCategory(category);
//        return product;
//    }
//
//
////    @Override
////    public Product deleteAProduct(Long productId) {
////        RestTemplate restTemplate= restTemplateBuilder.requestFactory(
////                HttpComponentsClientHttpRequestFactory.class
////        ).build();
////
////        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity= requestForEntity(
////                HttpMethod.DELETE,
////                "https://fakestoreapi.com/products/{productId}",
////                productId,
////                FakeStoreProductDto.class
////        );
////
////        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponseEntity.getBody());
////    }
//}
