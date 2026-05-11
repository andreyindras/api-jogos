package com.api.jogos.controller;

import com.api.jogos.model.Jogo;
import com.api.jogos.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listarTodos() {
        return ResponseEntity.ok(jogoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jogoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Jogo> criar(@Valid @RequestBody Jogo jogo) {
        Jogo novoJogo = jogoService.salvar(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Jogo jogo) {

        return ResponseEntity.ok(jogoService.atualizar(id, jogo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}