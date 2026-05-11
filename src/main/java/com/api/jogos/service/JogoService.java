package com.api.jogos.service;

import com.api.jogos.exception.ApiException;
import com.api.jogos.model.Jogo;
import com.api.jogos.repository.JogoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    public Jogo buscarPorId(Long id) {

        return jogoRepository.findById(id)
                .orElseThrow(() ->
                        new ApiException("Jogo não encontrado", HttpStatus.NOT_FOUND)
                );
    }

    public Jogo salvar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public Jogo atualizar(Long id, Jogo jogoAtualizado) {
        Jogo jogo = buscarPorId(id);

        jogo.setNome(jogoAtualizado.getNome());
        jogo.setTipo(jogoAtualizado.getTipo());
        jogo.setNota(jogoAtualizado.getNota());
        jogo.setReview(jogoAtualizado.getReview());

        return jogoRepository.save(jogo);
    }

    public void deletar(Long id) {
        Jogo jogo = buscarPorId(id);

        jogoRepository.delete(jogo);
    }
}