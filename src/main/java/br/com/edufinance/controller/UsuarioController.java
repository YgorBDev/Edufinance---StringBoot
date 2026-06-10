package br.com.edufinance.controller;

import br.com.edufinance.model.Usuario;
import br.com.edufinance.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> findAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/email")
    public List<Usuario> findByEmail(@RequestParam String email) {
        return List.of(service.findByEmail(email));
    }

    @GetMapping("/nivel")
    public List<Usuario> findByNivel(@RequestParam Integer nivel) {
        return service.findByNivel(nivel);
    }

    @GetMapping("/xp-maior")
    public List<Usuario> findByXpGreaterThan(@RequestParam Integer xp) {
        return service.findByXpGreaterThan(xp);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.update(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
