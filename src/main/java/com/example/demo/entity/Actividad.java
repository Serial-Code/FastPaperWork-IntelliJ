package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.sql.Date;
@Entity
@Table(name = "actividad")
@Getter
@Setter
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idactividad", unique = true)
    private Long id;

    @Column
    private Date fecha;

    @Column
    private int cantidades;


    @NotEmpty(message = "El campo movimiento no puede ser vacio")
    @Column(nullable = false)
    private String movimiento;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Product product;
}
