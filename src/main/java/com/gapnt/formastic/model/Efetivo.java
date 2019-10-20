package com.gapnt.formastic.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
