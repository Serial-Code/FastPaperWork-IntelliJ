package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column
    private Date fecha;

    @Column
    private int cantidad;

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "iduser")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn (name = "idforma_de_pago")
    @JsonBackReference
    private Forma_de_pago forma_de_pago;



}
