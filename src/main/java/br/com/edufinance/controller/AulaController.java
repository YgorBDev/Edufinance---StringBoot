package br.com.edufinance.controller;

import br.com.edufinance.model.Aula;
import br.com.edufinance.service.AulaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    private final AulaService service;

    public AulaController(AulaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aula> findAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/tipo-conteudo")
    public List<Aula> findByTipoConteudo(@RequestParam String tipoConteudo) {
        return service.findByTipoConteudo(tipoConteudo);
    }

    @GetMapping("/duracao-maior")
    public List<Aula> findByDuracaoMinutosGreaterThan(@RequestParam Integer minutos) {
        return service.findByDuracaoMinutosGreaterThan(minutos);
    }

    @PostMapping
    public ResponseEntity<Aula> create(@RequestBody Aula aula) {
        return ResponseEntity.ok(service.save(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> update(@PathVariable Long id, @RequestBody Aula aula) {
        return ResponseEntity.ok(service.update(id, aula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
