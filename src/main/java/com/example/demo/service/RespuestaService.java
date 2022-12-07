package com.example.demo.service;

import com.example.demo.entity.Respuesta;
import com.example.demo.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;

    public List<Respuesta> getRespuestas(){
        return respuestaRepository.findAll();
    }

    public Respuesta saveRespuesta(Respuesta respuesta){
        return respuestaRepository.save(respuesta);
    }

    public Respuesta getRespuesta(Integer id){
        return respuestaRepository.findById(id).get();
    }

    public Respuesta updateRespuesta(Respuesta respuesta){
        return respuestaRepository.save(respuesta);
    }

    public void deleteRespuesta(Integer id){
        respuestaRepository.deleteById(id);
    }
}
