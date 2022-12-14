package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.Forma_de_pagoService;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private Forma_de_pagoService forma_de_pagoService;

    @Autowired
    private UserServices userServices;




    @GetMapping("/pedido/todo")
    public String getPqrssAll(Model model){
        List<Pedido> pedidos  = pedidoService.getPedidos();
        model.addAttribute("pedidos", pedidos);
        return "pedido/allpedido";
    }

    @GetMapping("/pedido/all")
    public String getPedidos(Model model){

        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User loginUser = (User) authentication.getPrincipal();

            List<Pedido> pedidos = pedidoRepository.getPedidoByUser(loginUser.getId());

            model.addAttribute("pedidos", pedidos);

            /* List<Pedido> pedidos = pedidoService.getPedidos();
            List<Product> products = productService.getProducts();
            List<Forma_de_pago> forma_de_pagos = forma_de_pagoService.getForma_de_pagos();
            List<User> userss = userServices.getUsers();
            model.addAttribute("pedidos", pedidos);
            model.addAttribute("products", products);
            model.addAttribute("forma_de_pagos", forma_de_pagos);
            model.addAttribute("userss", userss);*/

            return "pedido/all";
        }catch (Exception ex) {
            return "error";
        }

    }


    @GetMapping("/pedido/new")
    public String showNewPedido(Model model){
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("forma_de_pagos", forma_de_pagoService.getForma_de_pagos());
        model .addAttribute("userss", userServices.getUsers());
        return "pedido/new";
    }

    @PostMapping("/pedido/save")
    public String newPedido(@Valid Pedido pedido, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("products", productService.getProducts());
            model.addAttribute("forma_de_pagos", forma_de_pagoService.getForma_de_pagos());
            model .addAttribute("userss", userServices.getUsers());

            return "pedido/new";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginUser = (User) authentication.getPrincipal();


        if (pedido.getCantidad() < 1){
            result.hasErrors();
            model.addAttribute("products", productService.getProducts());
            model.addAttribute("forma_de_pagos", forma_de_pagoService.getForma_de_pagos());
            model .addAttribute("userss", userServices.getUsers());
            return "pedido/new";
        } else {
            pedido.setTotal(pedido.getCantidad() * pedido.getProduct().getPrice());
        }

        pedido.setUser(loginUser);
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
    public String updatePedido(@PathVariable Long id,@Valid Pedido pedido, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("products", productService.getProducts());
            model.addAttribute("forma_de_pagos", forma_de_pagoService.getForma_de_pagos());
            model .addAttribute("userss", userServices.getUsers());

            return "pedido/update";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginUser = (User) authentication.getPrincipal();

        pedido.setTotal(pedido.getCantidad() * pedido.getProduct().getPrice());

        pedido.setUser(loginUser);

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
