package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "inventario")
@Getter
@Setter
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idinventario", unique = true)
    private Integer id;

    @Column(name = "categoria" ,length = 50, nullable = false)
    private String categoria;
    @Column(name = "entradas", length = 50, nullable = false)
    private int entradas;
    @Column(name = "salidas", length = 50, nullable = false)
    private int salidas;
    @Column(name = "descripcion",columnDefinition = "text")
    private String descripcion;

}
