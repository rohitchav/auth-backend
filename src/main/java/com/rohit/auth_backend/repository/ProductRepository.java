package com.rohit.auth_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.auth_backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserId(Long userId);
    
    
}
