package br.com.edufinance.service;

import br.com.edufinance.model.Aula;
import br.com.edufinance.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    private final AulaRepository repository;

    public AulaService(AulaRepository repository) {
        this.repository = repository;
    }

    public List<Aula> listAll() {
        return repository.findAll();
    }

    public Aula findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Aula não encontrada."));
    }

    public List<Aula> findByTipoConteudo(String tipoConteudo) {
        return repository.findByTipoConteudo(tipoConteudo);
    }

    public List<Aula> findByDuracaoMinutosGreaterThan(Integer minutos) {
        return repository.findByDuracaoMinutosGreaterThan(minutos);
    }

    public Aula save(Aula aula) {
        return repository.save(aula);
    }

    public Aula update(Long id, Aula aulaAtualizada) {
        Aula existente = findById(id);
        existente.setTitulo(aulaAtualizada.getTitulo());
        existente.setDescricao(aulaAtualizada.getDescricao());
        existente.setDuracaoMinutos(aulaAtualizada.getDuracaoMinutos());
        existente.setTipoConteudo(aulaAtualizada.getTipoConteudo());
        existente.setLinkVideo(aulaAtualizada.getLinkVideo());
        existente.setDataPublicacao(aulaAtualizada.getDataPublicacao());
        return repository.save(existente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
