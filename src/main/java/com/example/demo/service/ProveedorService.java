package com.example.demo.service;

import com.example.demo.entity.Proveedor;
import com.example.demo.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getProveedores(){
        return proveedorRepository.findAll();
    }

    public Proveedor saveProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public Proveedor getProveedor(Integer id){
        return proveedorRepository.findById(id).get();
    }

    public Proveedor updateProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Integer id){
        proveedorRepository.deleteById(id);
    }
}
