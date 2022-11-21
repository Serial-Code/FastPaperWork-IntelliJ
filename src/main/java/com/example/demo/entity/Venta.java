package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(length = 50, nullable = false)
    private Date fecha;
    @Column(length = 50, nullable = false)
    private int cantidad;
    @Column(columnDefinition = "text")
    private String detalle;
    @Column(length = 50, nullable = false)
    private double total;
}
