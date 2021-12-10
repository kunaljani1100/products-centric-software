package com.products.main.models;

import lombok.Data;

/**
 * GetProductRequest models the POST request sent by the user to get products based on a category.
 */
@Data
public class GetProductRequest {
    private String category;
    private int pageNumber;
    private int maxEntries;
}
