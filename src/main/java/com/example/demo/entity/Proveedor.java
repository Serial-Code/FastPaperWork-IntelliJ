package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idproveedor", unique = true)
    private Integer id;

    @Column(length = 50, nullable = false)
    private Integer RUT;

    @NotEmpty(message = "El campo nombre no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String primer_nombre;

    @NotEmpty(message = "El campo nombre no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String segundo_nombre;

    @NotEmpty(message = "El campo apellido no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String primer_apellido;

    @NotEmpty(message = "El campo apellido no puede ser vacio")
    @Column(length = 50, nullable = false)
    private String segundo_apellido;

    @Column(name = "telefono", length = 10, nullable = false)
    private Integer telefono;

}
