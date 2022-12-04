package com.example.demo.controller;

import com.example.demo.entity.Cotizacion;
import com.example.demo.service.CotizacionService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    @Autowired
    private ProductService productService;

    @GetMapping("/cotizacion/all")
    public String getCotizaciones(Model model) {
        List<Cotizacion> cotizaciones = cotizacionService.getCotizaciones();
        model.addAttribute("cotizaciones", cotizaciones);
        return "cotizacion/all";
    }

    @GetMapping("/cotizacion/new")
    public String showNewCotizacion(Model model){
        model.addAttribute("cotizacion", new Cotizacion());
        model.addAttribute("products", productService.getProducts());
        return "cotizacion/new";
    }

    @PostMapping("/cotizacion/save")
    public String newCotizacion(@Valid Cotizacion cotizacion, BindingResult result){
        if (result.hasErrors()){
            return "/cotizacion/new";
        }
        cotizacionService.saveCotizacion(cotizacion);
        return "redirect:/cotizacion/all";
    }

    @GetMapping("/cotizacion/update/{id}")
    public String showUpdateCotizacion(@PathVariable Long id, Model model){
        model.addAttribute("cotizacion", cotizacionService.getCotizacion(id));
        model.addAttribute("products", productService.getProducts());
        return "cotizacion/update";
    }

    @PostMapping("/cotizacion/update/{id}")
    public String updateCotizacion(@PathVariable Long id, Cotizacion cotizacion){
        cotizacion.setId(id);
        cotizacionService.updateCotizacion(cotizacion);
        return "redirect:/cotizacion/all";
    }

    @GetMapping("/cotizacion/delete/{id}")
    public String deleteCotizacion(@PathVariable Long id){
        cotizacionService.deleteCotizacion(id);
        return "redirect:/cotizacion/all";
    }
}
