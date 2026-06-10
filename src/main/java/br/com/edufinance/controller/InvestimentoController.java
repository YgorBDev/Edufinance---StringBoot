package br.com.edufinance.controller;

import br.com.edufinance.model.Investimento;
import br.com.edufinance.service.InvestimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentoController {

    private final InvestimentoService service;

    public InvestimentoController(InvestimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Investimento> findAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investimento> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/tipo")
    public List<Investimento> findByTipo(@RequestParam String tipo) {
        return service.findByTipo(tipo);
    }

    @GetMapping("/risco")
    public List<Investimento> findByRisco(@RequestParam String risco) {
        return service.findByRisco(risco);
    }

    @PostMapping
    public ResponseEntity<Investimento> create(@RequestBody Investimento investimento) {
        return ResponseEntity.ok(service.save(investimento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investimento> update(@PathVariable Long id, @RequestBody Investimento investimento) {
        return ResponseEntity.ok(service.update(id, investimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
