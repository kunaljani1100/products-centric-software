package com.products.main.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductEntity {
    private String id;
    private String name;
    private String description;
    private String brand;
    private List<String> tags;
    private String category;
    private LocalDateTime createdAt;
}
