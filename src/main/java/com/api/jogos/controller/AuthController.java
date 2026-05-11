package com.api.jogos.controller;

import com.api.jogos.dto.LoginRequestDTO;
import com.api.jogos.dto.LoginResponseDTO;
import com.api.jogos.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {

        String token = authService.login(request);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}