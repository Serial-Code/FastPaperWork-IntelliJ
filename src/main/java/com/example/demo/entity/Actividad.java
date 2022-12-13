package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @CreationTimestamp
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(length = 20, nullable = false)
    private Date fecha;
    @NotNull(message="La cantidad es obligatorio")
    @Min(value = 1, message = "La cantidad minima es 1")
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
