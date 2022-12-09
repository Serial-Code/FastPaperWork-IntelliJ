package com.example.demo.controller;

import com.example.demo.entity.Cotizacion;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.CotizacionService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserServices;
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
public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    @Autowired
    private UserServices userServices;
    @Autowired
    private ProductService productService;

    @GetMapping("/cotizacion/all")
    public String getCotizaciones(Model model) {
        List<Cotizacion> cotizaciones = cotizacionService.getCotizaciones();
        List<Product> products = productService.getProducts();
        List<User> users = userServices.getUsers();
        model.addAttribute("cotizaciones", cotizaciones);
        model.addAttribute("products", products);
        model.addAttribute("users", users);
        return "cotizacion/all";
    }

    @GetMapping("/cotizacion/new")
    public String showNewCotizacion(Model model){
        model.addAttribute("cotizacion", new Cotizacion());
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("users", userServices.getUsers());
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
        model.addAttribute("users", userServices.getUsers());
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
