package com.products.main.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.products.main.entities.ProductEntity;
import com.products.main.models.GetProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class GetProductController {
    @Autowired
    MongoDatabase mongoDatabase;

    @RequestMapping(value = "/v1/products", method = RequestMethod.GET)
    public List<GetProductResponse> getRecord() {
        List<GetProductResponse> getProductResponses = new ArrayList<>();
        MongoCollection<ProductEntity> productEntities = mongoDatabase.getCollection("product_entities", ProductEntity.class);
        FindIterable<ProductEntity> productEntityFindIterable = productEntities.find();
        for (ProductEntity productEntity : productEntityFindIterable) {
            GetProductResponse getProductResponse = new GetProductResponse();
            BeanUtils.copyProperties(productEntity, getProductResponse);
            getProductResponse.setId(productEntity.getId());
            getProductResponse.setCreatedAt(productEntity.getCreatedAt().toString() + "Z");
            getProductResponses.add(getProductResponse);
        }
        return getProductResponses;
    }
}
