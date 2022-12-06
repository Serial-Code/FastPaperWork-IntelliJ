package com.example.demo.controller;

import com.example.demo.entity.Forma_de_pago;
import com.example.demo.entity.Pedido;
import com.example.demo.entity.Product;
import com.example.demo.service.Forma_de_pagoService;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductService productService;

    @Autowired
    private Forma_de_pagoService forma_de_pagoService;

    @GetMapping("/pedido/all")
    public String getPedidos(Model model){
        List<Pedido> pedidos = pedidoService.getPedidos();
        List<Product> products = productService.getProducts();
        List<Forma_de_pago> forma_de_pagos = forma_de_pagoService.getForma_de_pagos();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("products", products);
        model.addAttribute("forma_de_pagos", forma_de_pagos);
        return "pedido/all";
    }

    @GetMapping("/pedido/new")
    public String showNewPedido(Model model){
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("forma_de_pagos", forma_de_pagoService.getForma_de_pagos());
        return "pedido/new";
    }

    @PostMapping("/pedido/save")
    public String newPedido(Pedido pedido){
        pedidoService.savePedido(pedido);
        return "redirect:/pedido/all";
    }

    @GetMapping("/pedido/update/{id}")
    public String showUpdatePedido(@PathVariable Long id, Model model){
        model.addAttribute("pedido", pedidoService.getPedido(id));
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("forma_de_pagos", forma_de_pagoService.getForma_de_pagos());
        return "pedido/update";
    }

    @PostMapping("/pedido/update/{id}")
    public String updatePedido(@PathVariable Long id,Pedido pedido){
        pedido.setId(id);
        pedidoService.updatePedido(pedido);
        return "redirect:/pedido/all";
    }

    @GetMapping("/pedido/delete/{id}")
    public String deletePedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
        return "redirect:/pedido/all";
    }
}
