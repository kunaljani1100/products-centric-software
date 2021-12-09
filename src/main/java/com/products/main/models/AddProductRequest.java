package com.products.main.models;

import lombok.Data;

import java.util.List;

@Data
public class AddProductRequest {
    private String name;
    private String description;
    private String brand;
    private List<String> tags;
    private String category;
}
