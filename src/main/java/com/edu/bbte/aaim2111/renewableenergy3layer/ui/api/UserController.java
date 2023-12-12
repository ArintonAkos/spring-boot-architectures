package com.edu.bbte.aaim2111.renewableenergy3layer.ui.api;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.services.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
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