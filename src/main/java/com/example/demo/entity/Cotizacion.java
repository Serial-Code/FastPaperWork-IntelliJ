package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@Table(name = "cotizacion")
@Getter
@Setter
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcotizacion", unique = true)
    private Long id;

    @NotEmpty(message = "El campo fecha no puede ser vacio")
    @Column(nullable = false)
    private Date fecha;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Product product;
}
