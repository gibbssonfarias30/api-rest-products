package com.backfcdev.apirestproducts.dto;

import lombok.Data;


@Data
public class ProductRequest {
    private Long id;
    private String name;
    private double price;
    private int amount;
    private String imageUrl;
    private Long categoryId;
}
