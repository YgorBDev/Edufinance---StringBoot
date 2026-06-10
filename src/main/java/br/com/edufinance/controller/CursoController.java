package br.com.edufinance.controller;

import br.com.edufinance.model.Curso;
import br.com.edufinance.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Curso> findAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/categoria")
    public List<Curso> findByCategoria(@RequestParam String categoria) {
        return service.findByCategoria(categoria);
    }

    @GetMapping("/dificuldade")
    public List<Curso> findByNivelDificuldade(@RequestParam String nivelDificuldade) {
        return service.findByNivelDificuldade(nivelDificuldade);
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.ok(service.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        return ResponseEntity.ok(service.update(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
