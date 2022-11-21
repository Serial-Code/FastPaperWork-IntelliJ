package com.example.demo.service;

import com.example.demo.entity.Calificacion;
import com.example.demo.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> getCalificaciones(){
        return calificacionRepository.findAll();
    }

    public Calificacion saveCalificacion(Calificacion calificacion){

        return calificacionRepository.save(calificacion);
    }

    public Calificacion getCalificacion(Long id){

        return calificacionRepository.findById(id).get();
    }

    public Calificacion updateCalificacion(Calificacion calificacion){

        return calificacionRepository.save(calificacion);
    }

    public void deleteCalificacion(Long id){

        calificacionRepository.deleteById(id);
    }

}