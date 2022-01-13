package com.example.brocante.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.brocante.models.DTOs.ProductDTO;
import com.example.brocante.models.forms.ProductForm;
import com.example.brocante.services.serviceimpls.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create one
    // POST - http://localhost:8080/product
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductForm form) {
        
        return ResponseEntity.ok(this.productService.insert(form));
    }

    // Create multiple

    // Read or Retrieve one by id
    // GET - http://localhost:8080/product/{id}
    @GetMapping("/{id}")
    // public ResponseEntity<ProductDTO> getOneById(@PathVariable(name = "id") Long id)
    public ResponseEntity<ProductDTO> getOneById(@PathVariable Long id) {
        
        return ResponseEntity.ok(this.productService.getOneById(id));
    }
    
    // Read or Retrieve multiple
    
    // Read or Retrieve all
    // GET - http://localhost:8080/product
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        
        return ResponseEntity.ok(this.productService.getAll());
    }
    
    // Update one by id
    // PUT - http://localhost:8080/product/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductForm form, @PathVariable Long id) {
        
        return ResponseEntity.ok(this.productService.update(form, id));
    }
    
    // Update multiple
    
    // Update all
    
    // Delete one by id
    // DELETE - http://localhost:8080/product/{id}
    @DeleteMapping("/{id}")
    // public ResponseEntity<Long> delete(@PathVariable(name = "id") Long id)
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        
        return ResponseEntity.ok(this.productService.delete(id));
    }

    // Delete multiple
    
    // Delete all
}
