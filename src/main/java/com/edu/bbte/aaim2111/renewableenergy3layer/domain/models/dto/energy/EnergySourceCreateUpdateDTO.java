package com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergySourceCreateUpdateDTO {
    @NotNull
    private String type;

    @NotNull
    private Double capacity;

    private boolean isAvailable;

    @NotNull
    private Double stock;

    @NotNull
    private Double price;

    private Long providerId;
}