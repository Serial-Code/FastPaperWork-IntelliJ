package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "calificacion")
@Getter
@Setter
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcalificacion", unique = true)
    private Long id;


    @Column(nullable = false)
    private Date fecha;


    @Column(length = 50, nullable = false)
    private int puntuacion;

    @Column(length = 50, nullable = false)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;
}
