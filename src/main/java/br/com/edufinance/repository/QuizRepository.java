package br.com.edufinance.repository;

import br.com.edufinance.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCategoria(String categoria);

    List<Quiz> findByNivel(String nivel);

    List<Quiz> findByPontuacaoMaximaGreaterThan(Integer pontuacao);
}