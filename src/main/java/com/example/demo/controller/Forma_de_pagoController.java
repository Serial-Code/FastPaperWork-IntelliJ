package com.example.demo.controller;

import com.example.demo.entity.Forma_de_pago;
import com.example.demo.service.Forma_de_pagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Forma_de_pagoController {
    @Autowired
    private Forma_de_pagoService forma_de_pagoService;


    @GetMapping("/formaPago/all")
    public String getForma_de_pagos(Model model) {
        List<Forma_de_pago> forma_de_pagos = forma_de_pagoService.getForma_de_pagos();
        model.addAttribute("forma_de_pagos", forma_de_pagos);
        return "formaPago/all";
    }

    @GetMapping("/formaPago/new")
    public String showNewForma_de_pago(Model model){
        model.addAttribute("forma_de_pago", new Forma_de_pago());
        return "formaPago/new";
    }

    @PostMapping("/formaPago/save")
    public String newForma_de_pago(@Valid Forma_de_pago forma_de_pago, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("forma_de_pago", forma_de_pagoService.getForma_de_pagos());
            return "/formaPago/new";
        }
        forma_de_pagoService.save(forma_de_pago);
        return "redirect:/formaPago/all";
    }

    @GetMapping("/formaPago/update/{id}")
    public String showUpdateForma_de_pago(@PathVariable Integer id, Model model){
        model.addAttribute("formaPago", forma_de_pagoService.getForma_de_pagos(id));
        return "formaPago/update";
    }

    @PostMapping("/formaPago/update/{id}")
    public String updateForma_de_pago(@PathVariable Integer id,@Valid Forma_de_pago forma_de_pago, Model model, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("forma_de_pago", forma_de_pagoService.getForma_de_pagos());
            return "/formaPago/new";
        }
        forma_de_pago.setIdforma_de_pago(id);
        forma_de_pagoService.save(forma_de_pago);
        return "redirect:/formaPago/all";

    }

    @GetMapping("/formaPago/delete/{id}")
    public String deleteForma_de_pago(@PathVariable Integer id){
        forma_de_pagoService.deleteForma_de_pago(id);
        return "redirect:/formaPago/all";
    }

}
