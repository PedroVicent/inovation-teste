package com.inovation.teste.InovationTeste.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nomePessoa;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

}
