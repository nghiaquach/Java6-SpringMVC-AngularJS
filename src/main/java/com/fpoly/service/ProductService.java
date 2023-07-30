package com.fpoly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.dao.ProductDAO;
import com.fpoly.entity.Product;


@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public List<Product> getAllProducts(){
        return productDAO.findAll();
    }
}
