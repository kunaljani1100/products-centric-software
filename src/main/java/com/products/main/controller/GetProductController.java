package com.products.main.controller;

import com.products.main.models.GetProductResponse;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableWebMvc
@RestController
@CrossOrigin
public class GetProductController {

    @Autowired
    private Connection connection;

    @RequestMapping(value = "/v1/products", method = RequestMethod.GET)
    public List<GetProductResponse> getRecord() {
        List<GetProductResponse> getProductResponses = new ArrayList<>();
        String selectStatement = "SELECT id, name, description, brand, tags, category, created_at FROM public.products";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GetProductResponse getProductResponse = new GetProductResponse();
                getProductResponse.setId(resultSet.getString("id"));
                getProductResponse.setName(resultSet.getString("name"));
                getProductResponse.setDescription(resultSet.getString("description"));
                getProductResponse.setBrand(resultSet.getString("brand"));
                getProductResponse.setCategory(resultSet.getString("category"));
                getProductResponse.setCreatedAt(resultSet.getTimestamp("created_at").toString() + "Z");
                List<String> tags = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(resultSet.getString("tags"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    tags.add(jsonArray.getString(i));
                }
                getProductResponse.setTags(tags);
                getProductResponses.add(getProductResponse);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return getProductResponses;
    }
}
