package br.com.edufinance.service;

import br.com.edufinance.model.Simulacao;
import br.com.edufinance.repository.SimulacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulacaoService {

    private final SimulacaoRepository repository;

    public SimulacaoService(SimulacaoRepository repository) {
        this.repository = repository;
    }

    public List<Simulacao> listAll() {
        return repository.findAll();
    }

    public Simulacao findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Simulação não encontrada."));
    }

    public List<Simulacao> findByUsuarioId(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<Simulacao> findByPrazoMeses(Integer prazoMeses) {
        return repository.findByPrazoMeses(prazoMeses);
    }

    public Simulacao save(Simulacao simulacao) {
        return repository.save(simulacao);
    }

    public Simulacao update(Long id, Simulacao simulacaoAtualizada) {
        Simulacao existente = findById(id);
        existente.setUsuarioId(simulacaoAtualizada.getUsuarioId());
        existente.setValorInicial(simulacaoAtualizada.getValorInicial());
        existente.setAporteMensal(simulacaoAtualizada.getAporteMensal());
        existente.setPrazoMeses(simulacaoAtualizada.getPrazoMeses());
        existente.setRentabilidadeAnual(simulacaoAtualizada.getRentabilidadeAnual());
        existente.setValorFinal(simulacaoAtualizada.getValorFinal());
        existente.setDataSimulacao(simulacaoAtualizada.getDataSimulacao());
        return repository.save(existente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
