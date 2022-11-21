package com.example.demo.service;

import com.example.demo.entity.Inventario;
import com.example.demo.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getInventarios(){
        return inventarioRepository.findAll();
    }

    public Inventario saveInventario(Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    public Inventario getInventario(Integer id){
        return inventarioRepository.findById(id).get();
    }

    public Inventario updateInventario(Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    public void deleteInventario(Integer id){
        inventarioRepository.deleteById(id);
    }
}
