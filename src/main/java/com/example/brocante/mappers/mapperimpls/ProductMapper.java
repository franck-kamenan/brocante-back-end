package com.example.brocante.mappers.mapperimpls;

import com.example.brocante.mappers.basemappers.BaseMapper;
import com.example.brocante.models.entities.Product;
import com.example.brocante.models.forms.ProductForm;
import com.example.brocante.models.DTOs.ProductDTO;

import org.springframework.stereotype.Service;

@Service
public class ProductMapper implements BaseMapper<ProductForm, Product, ProductDTO>{
    
    @Override
    public Product formToEntity(ProductForm form) {

        Product product = new Product();
        product.setTitle(form.getTitle());
        product.setDescription(form.getDescription());
        product.setPrix(form.getPrix());
        return product;
    }
    
    @Override
    public ProductDTO entityToDto(Product entity) {
        
        if (entity != null && entity.getId() > 0) {
            
            return ProductDTO.builder()
                             .id(entity.getId())
                             .title(entity.getTitle())
                             .description(entity.getDescription())
                             .prix(entity.getPrix())
                             .build();
        }
        return null;
    }
        
    @Override
    public Product dtoToEntity(ProductDTO dto) {
    
        Product product = new Product();
        if (dto != null && dto.getId() > 0) {
            
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setDescription(dto.getDescription());
            product.setPrix(dto.getPrix());
        }
        return product;
    }
}