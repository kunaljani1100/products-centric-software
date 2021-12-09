package com.products.main.models;

import lombok.Data;

import java.util.List;

@Data
public class AddProductResponse {
    private String id;
    private String name;
    private String description;
    private String brand;
    private List<String> tags;
    private String category;
    private String createdAt;
}
