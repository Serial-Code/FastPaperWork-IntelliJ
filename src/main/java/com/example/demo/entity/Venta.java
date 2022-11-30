package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@Table(name = "venta")
@Getter
@Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idventa", unique = true)
    private Long id;

    @NotEmpty(message = "El campo fecha no puede ser vacio")
    @Column
    private Date fecha;


    @Column
    private int cantidad;

    @NotEmpty(message = "El campo detalle no puede ser vacio")
    @Column(columnDefinition = "text")
    private String detalle;

    @Column
    private double total;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Product product;
}
