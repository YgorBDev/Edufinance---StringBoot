package br.com.edufinance.repository;

import br.com.edufinance.model.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {

    List<Simulacao> findByUsuarioId(Long usuarioId);

    List<Simulacao> findByPrazoMeses(Integer prazoMeses);

    List<Simulacao> findByValorFinalGreaterThan(Double valorFinal);
}