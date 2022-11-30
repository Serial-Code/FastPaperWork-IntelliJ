package com.example.demo.controller;

import com.example.demo.entity.Inventario;
import com.example.demo.service.InventarioService;
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
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private ProductService productService;

    @GetMapping("/inventario/all")
    public String getInventarios(Model model){
        List<Inventario> inventarios = inventarioService.getInventarios();
        model.addAttribute("inventarios", inventarios);
        return "inventario/all";
    }

    @GetMapping("/inventario/new")
    public String showNewInventario(Model model){
        model.addAttribute("inventario", new Inventario());
        model.addAttribute("products", productService.getProducts());
        return "inventario/new";
    }

    @PostMapping("/inventario/save")
    public String newInventario(@Valid Inventario inventario, BindingResult result){
        if (result.hasErrors()){
            return "/inventario/new";
        }
        inventarioService.saveInventario(inventario);
        return "redirect:/inventario/all";
    }

    @GetMapping("/inventario/update/{id}")
    public String showUpdateInventario(@PathVariable Integer id, Model model){
        model.addAttribute("inventario", inventarioService.getInventario(id));
        model.addAttribute("products", productService.getProducts());
        return "inventario/update";
    }

    @PostMapping("/inventario/update/{id}")
    public String updateInventario(@PathVariable Integer id,Inventario inventario){
        inventario.setId(id);
        inventarioService.updateInventario(inventario);
        return "redirect:/inventario/all";
    }

    @GetMapping("/inventario/delete/{id}")
    public String deleteInventario(@PathVariable Integer id){
        inventarioService.deleteInventario(id);
        return "redirect:/inventario/all";
    }

}