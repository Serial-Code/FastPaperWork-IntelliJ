package com.example.demo.controller;

import com.example.demo.entity.Venta;
import com.example.demo.service.ProductService;
import com.example.demo.service.VentaService;
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
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductService productService;

    @GetMapping("/venta/all")
    public String getVentas(Model model){
        List<Venta> ventas = ventaService.getVentas();
        model.addAttribute("ventas", ventas);
        return "venta/all";
    }

    @GetMapping("/venta/new")
    public String showNewVenta(Model model){
        model.addAttribute("venta", new Venta());
        model.addAttribute("products", productService.getProducts());
        return "venta/new";
    }

    @PostMapping("/venta/save")
    public String newVenta(@Valid Venta venta, BindingResult result){
        if (result.hasErrors()){
            return "/venta/new";
        }
        ventaService.saveVenta(venta);
        return "redirect:/venta/all";
    }

    @GetMapping("/venta/update/{id}")
    public String showUpdateVenta(@PathVariable Long id, Model model){
        model.addAttribute("venta", ventaService.getVenta(id));
        model.addAttribute("products", productService.getProducts());
        return "venta/update";
    }

    @PostMapping("/venta/update/{id}")
    public String updateVenta(@PathVariable Long id,Venta venta){
        venta.setId(id);
        ventaService.updateVenta(venta);
        return "redirect:/venta/all";
    }

    @GetMapping("/venta/delete/{id}")
    public String deleteVenta(@PathVariable Long id){
        ventaService.deleteVenta(id);
        return "redirect:/venta/all";
    }

}
