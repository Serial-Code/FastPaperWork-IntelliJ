package com.example.demo.controller;

import com.example.demo.entity.Calificacion;
import com.example.demo.entity.Product;
import com.example.demo.service.CalificacionService;
import com.example.demo.service.ProductService;
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
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @Autowired
    private ProductService productService;

    @GetMapping("/calificacion/all")
    public String getCalificaciones(Model model){
        List<Calificacion> calificaciones = calificacionService.getCalificaciones();
        model.addAttribute("calificaciones", calificaciones);
        return "calificacion/all";
    }

    @GetMapping("/calificacion/new")
    public String showNewCalificacion(Model model){
        model.addAttribute("calificacion", new Calificacion());
        model.addAttribute("products", productService.getProducts());
        return "calificacion/new";
    }
    @PostMapping("/calificacion/save")
    public String newCalificacion(@Valid Calificacion calificacion, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("products", productService.getProducts());
            return "/calificacion/new";
        }
        calificacionService.saveCalificacion(calificacion);
        return "redirect:/calificacion/all";
    }
    @GetMapping("/calificacion/update/{id}")
    public String showUpdateCalificacion(@PathVariable Long id, Model model){
        model.addAttribute("calificacion", calificacionService.getCalificacion(id));
        model.addAttribute("products", productService.getProducts());
        return "calificacion/update";
    }
    @PostMapping("/calificacion/update/{id}")
    public String updateCalificacion(@PathVariable Long id,@Valid Calificacion calificacion,BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.getProducts());
            return "/calificacion/new";
        }
        calificacion.setId(id);
        calificacionService.updateCalificacion(calificacion);
        return "redirect:/calificacion/all";
    }
    @GetMapping("/calificacion/delete/{id}")
    public String deleteCalificacion(@PathVariable Long id){
        calificacionService.deleteCalificacion(id);
        return "redirect:/calificacion/all";
    }
}
