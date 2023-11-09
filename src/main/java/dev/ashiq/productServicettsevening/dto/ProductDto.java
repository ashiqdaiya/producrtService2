package dev.ashiq.productServicettsevening.dto;

import dev.ashiq.productServicettsevening.models.Category;
import io.micrometer.core.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
   //@Nullable
    private Long id;
    private String title;
    private double price;
    private String description;

    private CategoryDto categoryDto;
    //@Nullable
    private String image;
}
