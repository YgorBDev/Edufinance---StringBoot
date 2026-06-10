package br.com.edufinance.service;

import br.com.edufinance.model.Curso;
import br.com.edufinance.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> listAll() {
        return repository.findAll();
    }

    public Curso findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Curso não encontrado."));
    }

    public List<Curso> findByCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public List<Curso> findByNivelDificuldade(String nivelDificuldade) {
        return repository.findByNivelDificuldade(nivelDificuldade);
    }

    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    public Curso update(Long id, Curso cursoAtualizado) {
        Curso existente = findById(id);
        existente.setTitulo(cursoAtualizado.getTitulo());
        existente.setDescricao(cursoAtualizado.getDescricao());
        existente.setCategoria(cursoAtualizado.getCategoria());
        existente.setNivelDificuldade(cursoAtualizado.getNivelDificuldade());
        existente.setCargaHoraria(cursoAtualizado.getCargaHoraria());
        existente.setDataCriacao(cursoAtualizado.getDataCriacao());
        return repository.save(existente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
