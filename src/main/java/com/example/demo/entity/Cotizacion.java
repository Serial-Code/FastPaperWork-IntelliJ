package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "cotizacion")
@Getter
@Setter
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcotizacion", unique = true)
    private Long id;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column
    private Date fecha;

    @NotNull(message="El precio es obligatorio")
    @Column
    @Min(value = 50, message = "El precio total debe ser minimo $50 pesos")
    @Max(value = 100000, message = "El precio total debe ser maximo $100.000 pesos")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;
}