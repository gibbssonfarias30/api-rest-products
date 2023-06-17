package com.backfcdev.apirestproducts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int amount;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @PrePersist
    public void addCreatedDate(){
        createdDate = LocalDateTime.now();
    }
}
