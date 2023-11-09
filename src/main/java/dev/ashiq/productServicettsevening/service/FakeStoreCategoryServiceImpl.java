package dev.ashiq.productServicettsevening.service;

import dev.ashiq.productServicettsevening.models.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    private RestTemplateBuilder restTemplateBuilder;


    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;

    }
    @Override
    public List<Category> getAllCategories() {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<Category[]> response=restTemplate.getForEntity(
         "https://fakestoreapi.com/products/categories",
              Category[].class
        );
        Category[] categories=response.getBody();
        //List<Category> categories= List.of((response.getBody()));
        //assert categories != null;
       // List<String> ans= new ArrayList<>();
        assert categories != null;
        String[] ans =new String[categories.length];
        for(Category category:categories){

                category.setName(category.getName());
                for(int i=0;i<categories.length;i++)
                    ans[i]= String.valueOf(category);
                //ans.add(String.valueOf(category));
        }
        return null;
    }

    @Override
    public Category getProductsInCategory(Long categoryId) {
        return null;
    }
}
