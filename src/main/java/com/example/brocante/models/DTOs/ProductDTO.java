package com.example.brocante.models.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    
    private long id;
    private String title;
    private String description;
    private double prix;
}
