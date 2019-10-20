package com.gapnt.formastic.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_efetivos")
public class Efetivo {

    @Id
    @Column(name = "efe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "efe_nome",nullable = false)
    private String nome;

    @Column(name = "efe_fone",nullable = false)
    private String fone;

}
