package com.inovation.teste.InovationTeste.repository;

import com.inovation.teste.InovationTeste.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
