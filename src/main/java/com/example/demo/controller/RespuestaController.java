package com.example.demo.controller;

import com.example.demo.entity.Proveedor;
import com.example.demo.entity.Respuesta;
import com.example.demo.service.RespuestaService;
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
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping("/respuesta/all")
    public String getRespuestas(Model model){
        List<Respuesta> respuestas = respuestaService.getRespuestas();
        model.addAttribute("respuestas", respuestas);
        return "respuesta/all";
    }

    @GetMapping("/respuesta/new")
    public String showNewRespuesta(Model model){
        model.addAttribute("respuesta", new Respuesta());
        return "respuesta/new";
    }

    @PostMapping("/respuesta/save")
    public String newRespuesta(@Valid Respuesta respuesta, BindingResult result){
        if (result.hasErrors()){
            return "/respuesta/new";
        }
        respuestaService.saveRespuesta(respuesta);
        return "redirect:/respuesta/all";
    }

    @GetMapping("/respuesta/update/{id}")
    public String showUpdateRespuesta(@PathVariable Long id, Model model){
        model.addAttribute("respuesta", respuestaService.getRespuesta(id));
        return "respuesta/update";
    }

    @PostMapping("/respuesta/update/{id}")
    public String updateRespuesta(@PathVariable Long id,Respuesta respuesta){
        respuesta.setId(id);
        respuestaService.updateRespuesta(respuesta);
        return "redirect:/respuesta/all";
    }

    @GetMapping("/respuesta/delete/{id}")
    public String deleteRespuesta(@PathVariable Long id){
        respuestaService.deleteRespuesta(id);
        return "redirect:/respuesta/all";
    }

}
