package com.fpoly.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpoly.dao.OrderDAO;
import com.fpoly.dao.OrderDetailDAO;
import com.fpoly.entity.Order;
import com.fpoly.entity.OrderDetail;

@CrossOrigin("*")
@RestController
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
	OrderDetailDAO ddao;

    @GetMapping("/order")
    public Order create(JsonNode orderData){
        ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		orderDAO.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);

        return order;
    }
}
