package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpedido", unique = true)
    private Long id;


    @Column
    private Date fecha;


    @Column(length = 50, nullable = false)
    private int cantidad;

    @NotEmpty(message = "El campo direccion no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String direccion;

    @Column(length = 50, nullable = false)
    private int descuento;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idforma_de_pago")
    private Forma_de_pago forma_de_pago;


}
