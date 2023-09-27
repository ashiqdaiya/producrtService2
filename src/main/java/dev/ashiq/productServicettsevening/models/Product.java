package dev.ashiq.productServicettsevening.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product extends BaseModel{
   private String title;
   private double price;
   private String description;
   private Category category;
   private String image;
}
