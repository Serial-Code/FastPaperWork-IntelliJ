package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpedido", unique = true)
    private Long id;

    @Column(length = 50, nullable = false)
    private int cantidad;
    @Column(length = 50, nullable = false)
    private Date fecha;
    @Column(length = 50, nullable = false)
    private String direccion;
    @Column(length = 50, nullable = false)
    private double descuento;

}
