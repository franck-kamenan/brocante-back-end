package com.example.brocante.utils;

import com.example.brocante.models.entities.Product;
import com.example.brocante.repositories.ProductRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean{
    
    private final ProductRepository productRepository;

    public DatabaseFiller(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        
        Product p1 = new Product();
        p1.setTitle("lampe magique");
        p1.setDescription("en or");
        p1.setPrix(123.5);
        p1 = productRepository.save(p1);
        
        Product p2 = new Product();
        p2.setTitle("chaine maudite");
        p2.setDescription("en argent");
        p2.setPrix(46.75);
        p2 = productRepository.save(p2);
        
        Product p3 = new Product();
        p3.setTitle("pièce divine");
        p3.setDescription("en bronze");
        p3.setPrix(8.99);
        p3 = productRepository.save(p3);
    }
}
