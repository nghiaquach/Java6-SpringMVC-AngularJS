package com.fpoly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpoly.entity.Product;

@Service
public class ShoppingCartService {
    HashMap<String, List<Product>> cartMap = new HashMap<>();

    public void addToCart(String username,JsonNode _product){

         ObjectMapper mapper = new ObjectMapper();
		
		Product theProduct = mapper.convertValue(_product, Product.class);
        //String username, Product _product
        List<Product> products = cartMap.get(username);

        if(products == null){
            products = new ArrayList<Product>();
        }


        Boolean foundProduct = false;
        for (Product product : products) {
            if(product.getProduct_id() == theProduct.getProduct_id()){
                foundProduct = true;
            }
        }

        if(!foundProduct){
            products.add(theProduct);
        }
        cartMap.put(username, products);
    }

    public List<Product> getCarts(String username){
        return cartMap.get(username);
    }
}
