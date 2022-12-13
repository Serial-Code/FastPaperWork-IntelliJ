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

    @Min(value = 1, message = "Valor minimo 1")
    @Column(name = "cantidad_total")
    private int cantidad;

    @NotEmpty(message = "El campo direccion no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String direccion;

    @ManyToOne
    @NotNull(message = "Seleccionar un usuario")
    @JoinColumn(name = "id")
    @JsonBackReference
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
