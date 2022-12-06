package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    private Long id;

    @Column
    private Date fecha ;

    @Column(length = 300)
    private String respuesta;

    @ManyToOne
    @JoinColumn(name = "idpqrs")
    private Pqrs pqrs;
}
