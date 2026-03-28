package com.rohit.auth_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rohit.auth_backend.model.Product;
import com.rohit.auth_backend.model.User;
import com.rohit.auth_backend.repository.ProductRepository;
import com.rohit.auth_backend.repository.UserRepository;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public ProductService(ProductRepository productRepo, UserRepository userRepo) {
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }

    // ✅ GET PRODUCTS
    public List<Product> getProducts(Long userId) {
        return productRepo.findByUserId(userId);
    }

    // ✅ ADD PRODUCT
    public Product addProduct(Product product, Long userId) {
        User user = userRepo.findById(userId).orElseThrow();

        product.setUser(user);
        return productRepo.save(product);
    }

    // ✅ UPDATE PRODUCT
    public Product updateProduct(Long id, Product updated) {
        Product existing = productRepo.findById(id).orElseThrow();

        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());

        return productRepo.save(existing);
    }

    // ✅ DELETE PRODUCT
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}