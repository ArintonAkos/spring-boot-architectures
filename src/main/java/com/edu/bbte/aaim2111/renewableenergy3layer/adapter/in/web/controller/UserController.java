package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.controller;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.incoming.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.outgoing.UserDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.in.UserServiceUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceUseCase userService;

    @Autowired
    public UserController(UserServiceUseCase userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDisplayDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDisplayDTO> createUser(
            @Valid
            @RequestBody
            UserCreateUpdateDTO userCreateUpdateDTO
    ) {
        UserDisplayDTO source = userService.createUser(userCreateUpdateDTO);

        return ResponseEntity.ok(source);
    }
}