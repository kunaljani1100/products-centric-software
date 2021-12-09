package com.products.main.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.BsonTimestamp;
import org.bson.types.ObjectId;

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
