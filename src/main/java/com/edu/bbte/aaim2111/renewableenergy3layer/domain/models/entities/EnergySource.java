package com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class EnergySource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;

    @NotNull
    private Double capacity;

    private boolean isAvailable;

    @NotNull
    private Double stock;

    @NotNull
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Setter
    private User provider;

    public EnergySource(String type, Double capacity, boolean isAvailable, Double stock, Double price, User provider) {
        this.type = type;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
        this.stock = stock;
        this.price = price;
        this.provider = provider;
    }

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
