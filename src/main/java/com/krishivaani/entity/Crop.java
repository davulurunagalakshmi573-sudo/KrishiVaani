package com.krishivaani.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;

    private Double quantity;

    private Double price;

    private String farmerName;

    // Default Constructor
    public Crop() {
    }

    // Parameterized Constructor
    public Crop(Long id, String cropName, Double quantity, Double price, String farmerName) {
        this.id = id;
        this.cropName = cropName;
        this.quantity = quantity;
        this.price = price;
        this.farmerName = farmerName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }
}