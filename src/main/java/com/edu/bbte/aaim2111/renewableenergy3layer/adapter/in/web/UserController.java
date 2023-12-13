package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.UserDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.in.UserServicePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServicePort userService;

    @Autowired
    public UserController(UserServicePort userService) {
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