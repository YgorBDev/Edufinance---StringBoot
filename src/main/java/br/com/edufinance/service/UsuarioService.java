package br.com.edufinance.service;

import br.com.edufinance.model.Usuario;
import br.com.edufinance.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado por email."));
    }

    public List<Usuario> findByNivel(Integer nivel) {
        return repository.findByNivel(nivel);
    }

    public List<Usuario> findByXpGreaterThan(Integer xp) {
        return repository.findByXpGreaterThan(xp);
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuarioAtualizado) {
        Usuario existente = findById(id);
        existente.setNome(usuarioAtualizado.getNome());
        existente.setEmail(usuarioAtualizado.getEmail());
        existente.setSenha(usuarioAtualizado.getSenha());
        existente.setNivel(usuarioAtualizado.getNivel());
        existente.setXp(usuarioAtualizado.getXp());
        existente.setAtivo(usuarioAtualizado.getAtivo());
        existente.setDataCadastro(usuarioAtualizado.getDataCadastro());
        return repository.save(existente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
