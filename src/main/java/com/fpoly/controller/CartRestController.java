package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.entity.Product;
import com.fpoly.service.ShoppingCartService;

@CrossOrigin("*")
@RestController
public class CartRestController {
    
    @Autowired
    ShoppingCartService shoppingCartService;

    
    @PostMapping("/api/cart")
    public ResponseEntity<String> create(@RequestBody JsonNode product){
        shoppingCartService.addToCart("user2",product);
         return ResponseEntity.ok().build();
    }

    // @GetMapping("/api/cart/{username}")
    // public ResponseEntity<List<Product>> cart(@PathVariable("username") String username){
    //     List<Product> products = shoppingCartService.getCarts(username);
    //     if(products != null && products.size()>0){
    //         return ResponseEntity.ok(shoppingCartService.getCarts(username));    
    //     }
    //     return ResponseEntity.noContent().build();
    // }
}
