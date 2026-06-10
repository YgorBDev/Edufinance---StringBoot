package br.com.edufinance.repository;

import br.com.edufinance.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

    List<Investimento> findByTipo(String tipo);

    List<Investimento> findByRisco(String risco);

    List<Investimento> findByPrecoAtualGreaterThan(Double valor);
}