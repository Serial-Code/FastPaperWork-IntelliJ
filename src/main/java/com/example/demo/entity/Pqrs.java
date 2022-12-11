package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


    @Column
    private Date fecha;


    @Column
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private User user;

}
