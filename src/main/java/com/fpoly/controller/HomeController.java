package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.entity.Product;
import com.fpoly.service.ProductService;

@Controller
public class HomeController {

	 @Autowired
    ProductService productService;

	@RequestMapping("/auth/index")
	public String index(Model model){
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "admin/index";
	}

	@RequestMapping("/home/index")
	public String index(){
		return "/index";
	}
}