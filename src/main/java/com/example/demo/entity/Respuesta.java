package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "respuesta")
@Getter
@Setter
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrespuesta", unique = true)
    private Long id;

    @Column(columnDefinition = "text")
    private String respuesta;
}
