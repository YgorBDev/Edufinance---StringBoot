package br.com.edufinance.repository;

import br.com.edufinance.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByCategoria(String categoria);

    List<Curso> findByNivelDificuldade(String nivelDificuldade);

    List<Curso> findByCargaHorariaGreaterThan(Integer cargaHoraria);
}