package com.example.demo.controller;

import com.example.demo.entity.Proveedor;
import com.example.demo.service.ProveedorService;
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
public class ProveedorController {

        @Autowired
        private ProveedorService proveedorService;

        @GetMapping("/proveedor/all")
        public String getProveedores(Model model){
            List<Proveedor> proveedores = proveedorService.getProveedores();
            model.addAttribute("proveedores", proveedores);
            return "proveedor/all";
        }

        @GetMapping("/proveedor/new")
        public String showNewProveedor(Model model){
            model.addAttribute("proveedor", new Proveedor());
            return "proveedor/new";
        }

        @PostMapping("/proveedor/save")
        public String newProveedor(@Valid Proveedor proveedor, BindingResult result){
            if (result.hasErrors()){
                return "/proveedor/new";
            }
            proveedorService.saveProveedor(proveedor);
            return "redirect:/proveedor/all";
        }

        @GetMapping("/proveedor/update/{id}")
        public String showUpdateProveedor(@PathVariable Integer id, Model model){
            model.addAttribute("proveedor", proveedorService.getProveedor(id));
            return "proveedor/update";
        }

        @PostMapping("/proveedor/update/{id}")
        public String updateProveedor(@PathVariable Integer id,@Valid Proveedor proveedor,BindingResult result, Model model){
            if(result.hasErrors()){
                return "/proveedor/new";
            }
            proveedor.setId(id);
            proveedorService.updateProveedor(proveedor);
            return "redirect:/proveedor/all";
        }

        @GetMapping("/proveedor/delete/{id}")
        public String deleteProveedor(@PathVariable Integer id){
            proveedorService.deleteProveedor(id);
            return "redirect:/proveedor/all";
        }
}
