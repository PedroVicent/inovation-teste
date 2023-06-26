package com.inovation.teste.InovationTeste.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column(name = "PRODUTO", nullable = false)
    private String produto;

    @Column(name = "DATA", nullable = false)
    private LocalDateTime dataPedido;

    @OneToOne(cascade = CascadeType.MERGE)
    private Cliente clientePedido;

}
