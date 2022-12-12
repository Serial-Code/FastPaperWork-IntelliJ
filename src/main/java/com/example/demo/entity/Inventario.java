package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "inventario")
@Getter
@Setter
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idinventario", unique = true)
    private Integer id;

    @NotEmpty(message = "El campo categoria no puede ser vacio")
    @Column(name = "categoria" ,length = 30, nullable = false)
    private String categoria;


    @NotEmpty(message = "El campo descripcion no puede ser vacio")
    @Column(name = "descripcion",columnDefinition = "text")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

}
