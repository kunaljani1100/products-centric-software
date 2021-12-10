package com.products.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ProductApplication is the class that runs the web application on the server.
 */
@SpringBootApplication(scanBasePackages="com.products.main.controller")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
