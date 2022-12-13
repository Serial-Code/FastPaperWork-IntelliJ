package com.example.demo.controller;

import com.example.demo.entity.Actividad;
import com.example.demo.entity.Product;
import com.example.demo.service.ActividadService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ActividadController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ActividadService actividadService;

    @GetMapping("/actividad/all")
    public String getActividades(Model model){
        List<Actividad> actividades = actividadService.getActividades();
        List<Product> products = productService.getProducts();
        model.addAttribute("actividades", actividades);
        model.addAttribute("products", products);
        return "actividad/all";
    }

    @GetMapping("/actividad/new")
    public String showNewActividad(Model model){
        model.addAttribute("actividad", new Actividad());
        model.addAttribute("products", productService.getProducts());
        return "actividad/new";
    }

    @PostMapping("/actividad/save")
    public String newActividad(@Valid Actividad actividad, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.getProducts());
            return "/actividad/new";
        }
        actividadService.saveActividad(actividad);
        return "redirect:/actividad/all";
    }
}
