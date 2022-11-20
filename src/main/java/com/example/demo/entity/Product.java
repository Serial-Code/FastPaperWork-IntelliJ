package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String category;
    @Column
    private int quantity;
    @Column(length = 40, nullable = false)
    private String state;
    @Column
    private Double price;

}
