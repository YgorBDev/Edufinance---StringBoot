package br.com.edufinance.repository;

import br.com.edufinance.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    List<Aula> findByTipoConteudo(String tipoConteudo);

    List<Aula> findByDuracaoMinutosGreaterThan(Integer minutos);

    List<Aula> findByTituloContainingIgnoreCase(String titulo);
}