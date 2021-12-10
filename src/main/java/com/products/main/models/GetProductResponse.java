package com.products.main.models;

import lombok.Data;

import java.util.List;

/**
 * GetProductResponse is the response that is returned to the user on requesting all the products.
 */
@Data
public class GetProductResponse {
    private String id;
    private String name;
    private String description;
    private String brand;
    private List<String> tags;
    private String category;
    private String createdAt;
}
