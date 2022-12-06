package com.example.demo.service;

import com.example.demo.entity.Forma_de_pago;
import com.example.demo.repository.Forma_de_pagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Forma_de_pagoService {
    @Autowired
    private Forma_de_pagoRepository forma_de_pagoRepository;

    public List<Forma_de_pago> getForma_de_pagos(){ return forma_de_pagoRepository.findAll();}

    public Forma_de_pago save(Forma_de_pago forma_de_pago){
        return forma_de_pagoRepository.save(forma_de_pago);
    }

    public Forma_de_pago getForma_de_pagos(Integer id){
        return forma_de_pagoRepository.findById(id).get();
    }

    public Forma_de_pago updateForma_de_pagos(Forma_de_pago forma_de_pago){
        return forma_de_pagoRepository.save(forma_de_pago);
    }

    public void deleteForma_de_pago(Integer id){
        forma_de_pagoRepository.deleteById(id);
    }

}
