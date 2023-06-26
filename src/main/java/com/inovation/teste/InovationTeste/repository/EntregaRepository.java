package com.inovation.teste.InovationTeste.repository;

import com.inovation.teste.InovationTeste.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
