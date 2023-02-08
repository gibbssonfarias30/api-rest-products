package com.backfcdev.apirestproducts.dto;

import com.backfcdev.apirestproducts.model.Category;
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
    private Category category;
}
