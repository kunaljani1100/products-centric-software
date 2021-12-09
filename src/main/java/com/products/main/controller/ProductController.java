package com.products.main.controller;

import com.mongodb.client.MongoDatabase;
import com.products.main.database.DBConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;

@RestController
@CrossOrigin
public class ProductController {

    public ProductController() {
    }

    @Bean
    public MongoDatabase createConnectionToDatabase() {
        DBConnector connector = new DBConnector();
        connector.connect("mongodb://localhost:27017");
        return connector.getMongoDatabase();
    }

    @Bean
    public RouterFunctionMapping createRouterFunctionMapping() {
        return new RouterFunctionMapping();
    }
}

