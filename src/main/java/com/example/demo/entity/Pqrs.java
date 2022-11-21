package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(length = 50, nullable = false)
    private String tipo;
    @Column(columnDefinition = "text")
    private String descripcion;
    @Column(length = 50, nullable = false)
    private Date fecha;
}
