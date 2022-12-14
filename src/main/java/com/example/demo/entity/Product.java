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

    @NotEmpty(message = "El campo categoria no puede ser vacio")
    @Column
    private String category;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    @NotNull(message="La cantidad es obligatorio")
>>>>>>> ad5e44daa8902db8beadc649e5f44190d5852d59
    @Min(value = 1, message = "La cantidad minima es 1")
    @Column
    private int quantity;

>>>>>>> c767fc00d4c7ed1f21093d2c2ee7eb6c2c447c8f
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
