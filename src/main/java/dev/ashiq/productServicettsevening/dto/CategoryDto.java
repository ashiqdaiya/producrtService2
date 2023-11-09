package dev.ashiq.productServicettsevening.dto;

import dev.ashiq.productServicettsevening.models.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private String name;
    private String description;

    private List<ProductDto> product;
}
