package com.rohit.auth_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rohit.auth_backend.model.Product;
import com.rohit.auth_backend.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "https://benevolent-nougat-99bfa1.netlify.app")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // ✅ GET
    @GetMapping("/{userId}")
    public List<Product> getProducts(@PathVariable Long userId) {
        return service.getProducts(userId);
    }

    // ✅ ADD
    @PostMapping("/{userId}")
    public ResponseEntity<?> addProduct(@RequestBody Product product,
                                        @PathVariable Long userId) {

        Product saved = service.addProduct(product, userId);

        return ResponseEntity.ok(
            Map.of(
                "status", "success",
                "message", "Product Added Successfully",
                "data", saved
            )
        );
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,
                                           @RequestBody Product product) {

        Product updated = service.updateProduct(id, product);

        return ResponseEntity.ok(
            Map.of(
                "status", "success",
                "message", "Product Updated Successfully",
                "data", updated
            )
        );
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        service.deleteProduct(id);

        return ResponseEntity.ok(
            Map.of(
                "status", "success",
                "message", "Product Deleted Successfully"
            )
        );
    }
}