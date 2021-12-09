package com.products.main.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.products.main.entities.ProductEntity;
import com.products.main.models.AddProductRequest;
import com.products.main.models.AddProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class AddProductController {

    @Autowired
    MongoDatabase mongoDatabase;

    @RequestMapping(value = "/v1/products", method = RequestMethod.POST)
    public AddProductResponse addRecord(@RequestBody AddProductRequest addProductRequest) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(addProductRequest, productEntity);
        productEntity.setCreatedAt(LocalDateTime.now());
        productEntity.setId(RandomStringUtils.randomAlphanumeric(10));
        MongoCollection<ProductEntity> productEntities = mongoDatabase.getCollection("product_entities", ProductEntity.class);
        productEntities.insertOne(productEntity);
        AddProductResponse addProductResponse = new AddProductResponse();
        BeanUtils.copyProperties(productEntity, addProductResponse);
        addProductResponse.setId(productEntity.getId());
        addProductResponse.setCreatedAt(productEntity.getCreatedAt().toString() + "Z");
        return addProductResponse;
    }
}
