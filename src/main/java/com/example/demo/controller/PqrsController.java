package com.example.demo.controller;

import com.example.demo.DTO.ReportPqrsDTO;
import com.example.demo.entity.*;
import com.example.demo.enums.TipoReporteEnum;
import com.example.demo.repository.PqrsRepository;
import com.example.demo.service.*;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class PqrsController {

    @Autowired
    private PqrsService pqrsService;

    @Autowired
    private PqrsRepository pqrsRepository;

    @Autowired
    private UserServices userServices;


    // Reporte PQRS


    // Reporte PQRS

    @GetMapping("/pqrs/todo")
    public String getPqrssAll(Model model){
        List<Pqrs> pqrss = pqrsService.getPqrss();
        model.addAttribute("pqrss", pqrss);
        return "pqrs/allpqrs";
    }


    @GetMapping("/pqrs/all")
    public String getPqrss(Model model){

        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User loginUser = (User) authentication.getPrincipal();

            List<Pqrs> Pqrss = pqrsRepository.getPqrsByUser(loginUser.getId());


            model.addAttribute("pqrss", Pqrss);

            //List<Pqrs> Pqrss = pqrsService.getPqrss();
            //List<User> Users = userServices.getUsers();

            //model.addAttribute("users", Users);
            return "pqrs/all";



        } catch (Exception ex){
            return "error";
        }
    }

    @GetMapping("/pqrs/new")
    public String showNewPqrs(Model model){
        model.addAttribute("pqrs", new Pqrs());
        model.addAttribute("users", userServices.getUsers());
        return "pqrs/new";
    }

    @PostMapping("/pqrs/save")
    public String newPqrs(@Valid Pqrs pqrs, BindingResult result){
        if (result.hasErrors()){
            return "/pqrs/new";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginUser = (User) authentication.getPrincipal();

        pqrs.setUser(loginUser);
        pqrsService.savePqrs(pqrs);
        return "redirect:/pqrs/all";
    }

    @GetMapping("/pqrs/update/{id}")
    public String showUpdatePqrs(@PathVariable Long id, Model model){
        model.addAttribute("pqrs", pqrsService.getPqrs(id));
        model.addAttribute("users", userServices.getUsers());
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
        try {
            pqrsService.deletePqrs(id);
            return "redirect:/pqrs/all";
        } catch (Exception e){
            return "redirect:/pqrs/all";
        }

    }



    // reportes
}
