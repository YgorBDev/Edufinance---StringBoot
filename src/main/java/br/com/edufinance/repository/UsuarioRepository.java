package br.com.edufinance.repository;

import br.com.edufinance.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNivel(Integer nivel);

    List<Usuario> findByXpGreaterThan(Integer xp);

    List<Usuario> findByAtivo(Boolean ativo);
}