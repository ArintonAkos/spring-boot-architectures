package com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergySourceDisplayDTO {
    private Long id;
    private String type;
    private Double capacity;
    private boolean isAvailable;
    private Double stock;
    private Double price;

    private Long providerId;
}