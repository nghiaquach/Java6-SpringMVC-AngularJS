package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpoly.entity.Product;
import com.fpoly.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/GetProducts")
    public List<Product> products() { 
        return productService.getAllProducts();
    }
}
