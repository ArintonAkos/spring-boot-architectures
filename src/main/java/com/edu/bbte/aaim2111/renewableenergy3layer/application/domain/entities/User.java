package com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
}