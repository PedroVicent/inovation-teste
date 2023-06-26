package com.inovation.teste.InovationTeste.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inovation.teste.InovationTeste.entity.Pedido;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntregaDTO {

    public Boolean statusEntregue;

    public Pedido pedido;

}
