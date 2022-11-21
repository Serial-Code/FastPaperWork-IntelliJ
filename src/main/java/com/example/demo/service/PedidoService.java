package com.example.demo.service;

import com.example.demo.entity.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }
    public Pedido savePedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public Pedido getPedido(Long id){
        return pedidoRepository.findById(id).get();
    }

    public Pedido updatePedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public void deletePedido(Long id){
        pedidoRepository.deleteById(id);
    }
}
