package br.com.edufinance.controller;

import br.com.edufinance.model.Quiz;
import br.com.edufinance.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping
    public List<Quiz> findAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/categoria")
    public List<Quiz> findByCategoria(@RequestParam String categoria) {
        return service.findByCategoria(categoria);
    }

    @GetMapping("/nivel")
    public List<Quiz> findByNivel(@RequestParam String nivel) {
        return service.findByNivel(nivel);
    }

    @PostMapping
    public ResponseEntity<Quiz> create(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(service.save(quiz));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> update(@PathVariable Long id, @RequestBody Quiz quiz) {
        return ResponseEntity.ok(service.update(id, quiz));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
