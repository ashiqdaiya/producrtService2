package dev.ashiq.productServicettsevening.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    private String name;
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Product> product;

}
