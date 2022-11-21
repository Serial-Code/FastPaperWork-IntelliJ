package com.example.demo.controller;

import com.example.demo.entity.Pqrs;
import com.example.demo.service.PqrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PqrsController {

    @Autowired
    private PqrsService pqrsService;

    @GetMapping("/pqrs/all")
    public String getPqrss(Model model){
        List<Pqrs> Pqrss = pqrsService.getPqrss();
        model.addAttribute("pqrss", Pqrss);
        return "pqrs/all";
    }

    @GetMapping("/pqrs/new")
    public String showNewPqrs(Model model){
        model.addAttribute("pqrs", new Pqrs());
        return "pqrs/new";
    }

    @PostMapping("/pqrs/save")
    public String newPqrs(Pqrs pqrs){
        pqrsService.savePqrs(pqrs);
        return "redirect:/pqrs/all";
    }

    @GetMapping("/pqrs/update/{id}")
    public String showUpdatePqrs(@PathVariable Long id, Model model){
        model.addAttribute("pqrs", pqrsService.getPqrs(id));
        return "pqrs/update";
    }

    @PostMapping("/pqrs/update/{id}")
    public String updatePqrs(@PathVariable Long id,Pqrs pqrs){
        pqrs.setId(id);
        pqrsService.updatePqrs(pqrs);
        return "redirect:/pqrs/all";
    }

    @GetMapping("/pqrs/delete/{id}")
    public String deletePqrs(@PathVariable Long id){
        pqrsService.deletePqrs(id);
        return "redirect:/pqrs/all";
    }
}
