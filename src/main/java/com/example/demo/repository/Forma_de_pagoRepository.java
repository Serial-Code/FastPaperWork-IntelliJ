package com.example.demo.repository;

import com.example.demo.entity.Forma_de_pago;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Forma_de_pagoRepository extends JpaRepository<Forma_de_pago, Integer> {
}
