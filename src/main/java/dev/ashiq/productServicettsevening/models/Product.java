package dev.ashiq.productServicettsevening.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
   private String title;
   private double price;
   private String description;

   @JsonManagedReference
   @ManyToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "category_id")
   private Category category;
   private String image;
}
