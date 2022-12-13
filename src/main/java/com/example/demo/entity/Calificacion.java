package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "calificacion")
@Getter
@Setter
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcalificacion", unique = true)
    private Long id;


    @CreationTimestamp
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column
    private Date fecha;


    @NotNull(message="La puntuación es obligatoria")
    @Min(value = 1, message = "La puntuación minima es 1")
    @Max(value = 5, message = "La puntuación maxima es 5")
    @Column
    private int puntuacion;

    @NotEmpty(message="Las observaciones son obligatorias")
    @Column(length = 50, nullable = false)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;
}
