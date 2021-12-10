package com.products.main.controller;

import com.products.main.models.AddProductRequest;
import com.products.main.models.AddProductResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * AddProductController handles the addition os products to the database.
 */
@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class AddProductController {

    @Autowired
    private Connection connection;

    @RequestMapping(value = "/v1/products", method = RequestMethod.POST)
    public AddProductResponse addRecord(@RequestBody AddProductRequest addProductRequest) {
        AddProductResponse addProductResponse = new AddProductResponse();
        String insertStatement = "INSERT INTO public.products VALUES (?,?,?,?,?,?,?)";
        JSONArray tagArray = new JSONArray();
        int i = 0;
        for (String tag:addProductRequest.getTags()) {
            tagArray.put(i, tag);
            i++;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            addProductResponse.setId(RandomStringUtils.randomAlphanumeric(10));
            preparedStatement.setString(1, addProductResponse.getId());
            addProductResponse.setName(addProductRequest.getName());
            preparedStatement.setString(2,addProductResponse.getName());
            addProductResponse.setDescription(addProductRequest.getDescription());
            preparedStatement.setString(3,addProductResponse.getDescription());
            addProductResponse.setBrand(addProductRequest.getBrand());
            preparedStatement.setString(4,addProductResponse.getBrand());
            addProductResponse.setTags(addProductRequest.getTags());
            preparedStatement.setString(5,tagArray.toString());
            addProductResponse.setCategory(addProductRequest.getCategory());
            preparedStatement.setString(6,addProductResponse.getCategory());
            addProductResponse.setCreatedAt(LocalDateTime.now().toString());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.parse(addProductResponse.getCreatedAt())));
            addProductResponse.setCreatedAt(LocalDateTime.now().toString() + "Z");
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return addProductResponse;
    }
}
