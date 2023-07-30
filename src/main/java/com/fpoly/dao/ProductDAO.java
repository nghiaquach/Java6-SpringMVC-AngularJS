package com.fpoly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fpoly.entity.Product;
import java.util.List;


public interface ProductDAO extends JpaRepository<Product, Integer>{    
    List<Product> findByNameLike(String name);
}