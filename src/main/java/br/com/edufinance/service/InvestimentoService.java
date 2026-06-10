package br.com.edufinance.service;

import br.com.edufinance.model.Investimento;
import br.com.edufinance.repository.InvestimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestimentoService {

    private final InvestimentoRepository repository;

    public InvestimentoService(InvestimentoRepository repository) {
        this.repository = repository;
    }

    public List<Investimento> listAll() {
        return repository.findAll();
    }

    public Investimento findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Investimento não encontrado."));
    }

    public List<Investimento> findByTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public List<Investimento> findByRisco(String risco) {
        return repository.findByRisco(risco);
    }

    public Investimento save(Investimento investimento) {
        return repository.save(investimento);
    }

    public Investimento update(Long id, Investimento investimentoAtualizado) {
        Investimento existente = findById(id);
        existente.setNomeAtivo(investimentoAtualizado.getNomeAtivo());
        existente.setTicker(investimentoAtualizado.getTicker());
        existente.setTipo(investimentoAtualizado.getTipo());
        existente.setRisco(investimentoAtualizado.getRisco());
        existente.setPrecoAtual(investimentoAtualizado.getPrecoAtual());
        existente.setRentabilidadeAnual(investimentoAtualizado.getRentabilidadeAnual());
        return repository.save(existente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
