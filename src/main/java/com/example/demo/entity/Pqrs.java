package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@Table(name = "pqrs")
@Getter
@Setter
public class Pqrs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpqrs", unique = true)
    private Long id;

    @NotEmpty(message = "El campo tipo no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String tipo;

    @NotEmpty(message = "El campo descripcion no puede ser vacio")
    @Column(columnDefinition = "text")
    private String descripcion;

    @NotEmpty(message = "El campo fecha no puede ser vacio")
    @Column(length = 50, nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idrespuesta")
    private Respuesta respuesta;
}
