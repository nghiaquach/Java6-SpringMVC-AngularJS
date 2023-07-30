package com.fpoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.entity.Order;
import com.fpoly.service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping("/api/order")
    public ResponseEntity<Order> create(@RequestBody JsonNode order){
        Order newOrder = orderService.create(order);
        return ResponseEntity.ok(newOrder);
    }
}
