package com.products.main.controller;

import com.products.main.database.DBConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@CrossOrigin
public class ProductController {

    public ProductController() {
    }

    @Bean
    public Connection createConnectionToDatabase() throws SQLException {
        DBConnector connector = new DBConnector();
        return connector.connect("jdbc:postgresql://localhost/");
    }

    @Bean
    public RouterFunctionMapping createRouterFunctionMapping() {
        return new RouterFunctionMapping();
    }
}

