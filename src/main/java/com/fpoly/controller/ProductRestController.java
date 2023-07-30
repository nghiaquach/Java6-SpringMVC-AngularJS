package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entity.Product;
import com.fpoly.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> products() { 
        if(productService.getAllProducts().size()>0){
            return ResponseEntity.ok(productService.getAllProducts());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
}