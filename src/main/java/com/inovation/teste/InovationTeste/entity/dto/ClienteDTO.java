package com.inovation.teste.InovationTeste.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {

    private String nomePessoa;

    private String telefone;

    private String endereco;

}
