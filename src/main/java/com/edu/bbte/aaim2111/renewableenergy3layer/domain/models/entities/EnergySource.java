package com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnergySource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
