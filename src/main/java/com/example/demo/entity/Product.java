package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    @Column
    private String name;

    @NotEmpty
    @Column
    private String category;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> a3e7a87c7aa3fe41ac9787f5bd008bc6c818d6c6
    @NotNull(message="La cantidad es obligatorio")
    @Min(value = 1, message = "La cantidad minima es 1")
    @Column
    private int quantity;

>>>>>>> c767fc00d4c7ed1f21093d2c2ee7eb6c2c447c8f
>>>>>>> 062032f4fa49540a0a00308cdf9981231e2fc5de
    @NotEmpty(message = "El campo estado no puede ser vacio")
    @Column
    private String state;

    @NotNull(message="El precio es obligatorio")
    @Column
    @Min(value = 50, message = "El precio total debe ser minimo $50 pesos")
    @Max(value = 100000, message = "El precio total debe ser maximo $100.000 pesos")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "idproveedor")
    @JsonBackReference
    private Proveedor proveedor;

}
