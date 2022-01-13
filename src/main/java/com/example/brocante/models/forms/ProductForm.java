package com.example.brocante.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductForm {
    
    @NotNull
    @Size(min = 2, max = 30)
    private String title;
    
    @NotNull
    @Size(min = 2, max = 30)
    private String description;
    
    private double prix;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    
}
