package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @NotEmpty(message = "El campo nombre no puede ser vacio")
    @Size(min = 3, max = 40)
    @Column(length = 50, nullable = false)
    private String name;

    @NotEmpty(message = "El campo categoria no puede ser vacio")
    @Column(length = 30, nullable = false)
    private String category;

    @NotEmpty(message = "El campo estado no puede ser vacio")
    @Column(length = 40, nullable = false)
    private String state;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "idproveedor")
    @JsonBackReference
    private Proveedor proveedor;

}
