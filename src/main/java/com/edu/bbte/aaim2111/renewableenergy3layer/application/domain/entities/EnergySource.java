package com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnergySource {
    private Long id;
    private String type;
    private Double capacity;
    private boolean available;
    private Double stock;
    private Double price;
    private User provider;

    public void decreaseStock(Double amount) {
        if (this.stock != null && this.stock >= amount) {
            this.stock -= amount;
        } else {
            throw new RuntimeException("Insufficient stock");
        }
    }

    public void increaseStock(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if (this.stock + amount > capacity) {
            throw new RuntimeException("Stock capacity exceeded");
        }

        this.stock += amount;
    }
}
