package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @Column
    private Date fecha;

    @Column
    private int cantidad;

    @NotEmpty(message = "El campo descripción no puede ser vacio")
    @Column(columnDefinition = "text")
    private String detalle;

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Proveedor product;
}