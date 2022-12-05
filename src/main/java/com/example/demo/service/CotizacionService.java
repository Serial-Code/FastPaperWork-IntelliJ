package com.example.demo.service;

import com.example.demo.entity.Cotizacion;
import com.example.demo.repository.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotizacionService {

    @Autowired
    private CotizacionRepository cotizacionRepository;

    public List<Cotizacion> getCotizaciones(){
        return cotizacionRepository.findAll();
    }

    public Cotizacion saveCotizacion(Cotizacion cotizacion){

        return cotizacionRepository.save(cotizacion);
    }

    public Cotizacion getCotizacion(Long id){

        return cotizacionRepository.findById(id).get();
    }

    public Cotizacion updateCotizacion(Cotizacion cotizacion){

        return cotizacionRepository.save(cotizacion);
    }

    public void deleteCotizacion(Long id){

        cotizacionRepository.deleteById(id);
    }
}
