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

    @Column
    private Date fecha;

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;
}