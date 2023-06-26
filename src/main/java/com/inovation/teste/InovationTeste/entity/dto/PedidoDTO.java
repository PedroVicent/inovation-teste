package com.inovation.teste.InovationTeste.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inovation.teste.InovationTeste.entity.Cliente;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDTO {

    private String produtos;

    private Cliente clientePedido;
}
