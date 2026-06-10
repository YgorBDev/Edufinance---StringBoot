package br.com.edufinance.service;

import br.com.edufinance.model.Quiz;
import br.com.edufinance.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public List<Quiz> listAll() {
        return repository.findAll();
    }

    public Quiz findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Quiz não encontrado."));
    }

    public List<Quiz> findByCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public List<Quiz> findByNivel(String nivel) {
        return repository.findByNivel(nivel);
    }

    public Quiz save(Quiz quiz) {
        return repository.save(quiz);
    }

    public Quiz update(Long id, Quiz quizAtualizado) {
        Quiz existente = findById(id);
        existente.setTitulo(quizAtualizado.getTitulo());
        existente.setCategoria(quizAtualizado.getCategoria());
        existente.setNivel(quizAtualizado.getNivel());
        existente.setQuantidadeQuestoes(quizAtualizado.getQuantidadeQuestoes());
        existente.setPontuacaoMaxima(quizAtualizado.getPontuacaoMaxima());
        return repository.save(existente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
