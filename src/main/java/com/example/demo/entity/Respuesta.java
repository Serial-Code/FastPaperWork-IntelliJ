package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "informacion")
    private String informacion;

    @ManyToOne
    @JoinColumn(name = "idpqrs")
    @JsonBackReference
    private Pqrs pqrs;

}
