package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "forma_de_pago")
@Getter
@Setter
public class Forma_de_pago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idforma_de_pago", unique = true)
    private Integer idforma_de_pago;


    @Column(name = "forma_de_pago" ,length = 30, nullable = false)
    private String forma_de_pago;
}
