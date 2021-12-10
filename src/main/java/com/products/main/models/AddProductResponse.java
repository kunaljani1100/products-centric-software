package com.products.main.models;

import lombok.Data;

import java.util.List;

/**
 * AddProductResponse is the response that is returned on adding a product to the database.
 */
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
