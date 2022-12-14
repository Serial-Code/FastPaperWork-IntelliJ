package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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


    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private String estado;

    @NotEmpty(message = "El campo direccion no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne
    @NotNull(message = "Seleccionar una forma de pago")
    @JoinColumn(name = "idforma_de_pago")
    @JsonBackReference
    private Forma_de_pago forma_de_pago;

    @ManyToOne
    @JoinColumn(name = "idusers")
    @JsonBackReference
    private User user;


}
