package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "energy_sources")
public class EnergySourceJpaEntity {
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
    private UserJpaEntity provider;

    public EnergySourceJpaEntity(String type, Double capacity, boolean isAvailable, Double stock, Double price, UserJpaEntity provider) {
        this.type = type;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
        this.stock = stock;
        this.price = price;
        this.provider = provider;
    }
}