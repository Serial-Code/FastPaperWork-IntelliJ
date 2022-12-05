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

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne
    @JoinColumn (name = "iduser")
    private User user;

    @ManyToOne
    @JoinColumn (name = "idforma_de_pago")
    private Forma_de_pago forma_de_pago;


}
