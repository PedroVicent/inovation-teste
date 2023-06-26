package com.inovation.teste.InovationTeste.authentication.repository;

import com.inovation.teste.InovationTeste.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);
}
