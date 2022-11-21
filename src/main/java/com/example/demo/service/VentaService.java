package com.example.demo.service;

import com.example.demo.entity.Venta;
import com.example.demo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getVentas(){

        return ventaRepository.findAll();
    }

    public Venta saveVenta(Venta venta){

        return ventaRepository.save(venta);
    }

    public Venta getVenta(Long id){

        return ventaRepository.findById(id).get();
    }

    public Venta updateVenta(Venta venta){

        return ventaRepository.save(venta);
    }

    public void deleteVenta(Long id){

        ventaRepository.deleteById(id);
    }

}
