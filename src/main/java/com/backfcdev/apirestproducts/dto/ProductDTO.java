package com.backfcdev.apirestproducts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private int amount;
    private String imageUrl;
    private String categoryName;
}
