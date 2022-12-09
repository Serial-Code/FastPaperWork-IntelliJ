package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "respuesta")
@Getter
@Setter
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrespuesta", unique = true)
    private Integer id;

    @Column
    private Date fecha;

    @Column(name = "informacion")
    private String informacion;

    @ManyToOne
    @JoinColumn(name = "idpqrs")
    private Pqrs pqrs;
}
