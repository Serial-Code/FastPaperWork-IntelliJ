package com.example.demo.service;

import com.example.demo.entity.Actividad;
import com.example.demo.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> getActividades(){

        return actividadRepository.findAll();
    }

    public Actividad saveActividad(Actividad actividad){

        return actividadRepository.save(actividad);
    }

    public Actividad getActividad(Long id){

        return actividadRepository.findById(id).get();
    }

}
