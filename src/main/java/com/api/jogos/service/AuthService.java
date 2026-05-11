package com.api.jogos.service;

import com.api.jogos.dto.LoginRequestDTO;
import com.api.jogos.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    public String login(LoginRequestDTO request) {

        if (request.getEmail().equals("usuario@esoft.com") && request.getPassword().equals("Abc123")) {
            return UUID.randomUUID().toString();
        }

        throw new ApiException("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
    }
}