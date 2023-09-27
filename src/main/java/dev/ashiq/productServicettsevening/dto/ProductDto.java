package dev.ashiq.productServicettsevening.dto;

import dev.ashiq.productServicettsevening.models.Category;
import io.micrometer.core.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
   //@Nullable
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    //@Nullable
    private String image;
}
