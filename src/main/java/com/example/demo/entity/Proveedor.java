package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idproveedor", unique = true)
    private Integer id;

    @NotNull(message = "El campo RUT no puede ser vacio")
    @Min(value = 10, message = "El campo RUT minimo es de 10 digitos")
    @Column(name = "RUT",length = 10, nullable = false)
    private int RUT;

    @Min(value = 10, message = "El campo telefono minimo es de 10 digitos")
    @Column(name = "telefono")
    private int telefono;
    @NotEmpty(message = "El campo nombre no puede ser vacio")
    @Column(name = "nombre_completo",length = 50, nullable = false)
    private String nombre_completo;



}
