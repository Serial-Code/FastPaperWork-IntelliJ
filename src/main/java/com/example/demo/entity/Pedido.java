package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "El campo fecha no puede ser vacio")
    @Column
    private Date fecha;

    @NotEmpty(message = "El campo cantidad no puede ser vacio")
    @Column(length = 50, nullable = false)
    private int cantidad;

    @NotEmpty(message = "El campo direccion no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String direccion;

    @NotEmpty(message = "El campo descuento no puede ser vacio")
    @Column(length = 50, nullable = false)
    private double descuento;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idforma_de_pago")
    private Forma_de_pago forma_de_pago;


}
