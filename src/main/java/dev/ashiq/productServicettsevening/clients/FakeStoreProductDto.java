package dev.ashiq.productServicettsevening.clients;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    //@Nullable
    private String image;
}
