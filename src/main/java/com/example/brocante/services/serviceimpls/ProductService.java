package com.example.brocante.services.serviceimpls;

import java.util.List;
import java.util.stream.Collectors;

import com.example.brocante.mappers.mapperimpls.ProductMapper;
import com.example.brocante.models.DTOs.ProductDTO;
import com.example.brocante.models.entities.Product;
import com.example.brocante.models.forms.ProductForm;
import com.example.brocante.repositories.ProductRepository;
import com.example.brocante.services.baseservices.BaseService;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements BaseService<ProductDTO, Long, ProductForm>{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // Create one
    @Override
    public ProductDTO insert(ProductForm form) {
        
        Product product = this.productMapper
                              .formToEntity(form);

        return this.productMapper
                   .entityToDto(this.productRepository
                                    .save(product));
    }

    // Create multiple

    // Read or Retrieve one by id
    @Override
    public ProductDTO getOneById(Long id) {
        
        return this.productMapper
                   .entityToDto(this.productRepository
                                    .findById(id)
                                    .orElse(null));
    }
    
    // Read or Retrieve multiple

    // Read or Retrieve all
    @Override
    public List<ProductDTO> getAll() {
        
        return this.productRepository
                   .findAll()
                   .stream()
                   .map(this.productMapper::entityToDto)
                   .collect(Collectors.toList());
    }
    
    // Update one by id
    @Override
    public ProductDTO update(ProductForm form, Long id) {
        
        Product product = this.productRepository
                              .findById(id)
                              .orElse(null);

        if (product != null) {
            
            product.setTitle(form.getTitle());
            product.setDescription(form.getDescription());
            product.setPrix(form.getPrix());
            this.productRepository.save(product);
        }
        return this.productMapper
                   .entityToDto(product);
    }
    
    // Update multiple

    // Update all
    
    // Delete one by id
    @Override
    public Long delete(Long id) {
        
        Product product = this.productRepository
                              .findById(id)
                              .orElse(null);
        
        if (product != null) {
            
            this.productRepository
                .delete(product);

            return product.getId();
        }
        return -1L;
    }

    // Delete multiple
    
    // Delete all
}