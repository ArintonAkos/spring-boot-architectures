package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.incoming;

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

    private boolean available;

    @NotNull
    private Double stock;

    @NotNull
    private Double price;

    private Long providerId;
}