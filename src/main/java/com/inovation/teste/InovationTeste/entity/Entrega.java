package com.inovation.teste.InovationTeste.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ENTREGA")
public class Entrega {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    public Long id;

    @Column(name = "STATUS", nullable = false)
    public Boolean statusEntregue;

    @OneToOne(cascade = CascadeType.MERGE)
    public Pedido pedido;

}
