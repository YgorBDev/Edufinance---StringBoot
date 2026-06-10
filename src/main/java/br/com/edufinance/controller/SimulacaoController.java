package br.com.edufinance.controller;

import br.com.edufinance.model.Simulacao;
import br.com.edufinance.service.SimulacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulacoes")
public class SimulacaoController {

    private final SimulacaoService service;

    public SimulacaoController(SimulacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Simulacao> findAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Simulacao> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/usuario")
    public List<Simulacao> findByUsuarioId(@RequestParam Long usuarioId) {
        return service.findByUsuarioId(usuarioId);
    }

    @GetMapping("/prazo")
    public List<Simulacao> findByPrazoMeses(@RequestParam Integer prazoMeses) {
        return service.findByPrazoMeses(prazoMeses);
    }

    @PostMapping
    public ResponseEntity<Simulacao> create(@RequestBody Simulacao simulacao) {
        return ResponseEntity.ok(service.save(simulacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Simulacao> update(@PathVariable Long id, @RequestBody Simulacao simulacao) {
        return ResponseEntity.ok(service.update(id, simulacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
