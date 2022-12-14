package com.example.demo.controller;

import com.example.demo.entity.Pqrs;
import com.example.demo.entity.Respuesta;
import com.example.demo.service.PqrsService;
import com.example.demo.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @Autowired
    private PqrsService pqrsService;



    @GetMapping("/respuesta/all")
    public String getRespuestas(Model model){
        List<Respuesta> respuestas = respuestaService.getRespuestas();
        List<Pqrs> pqrss = pqrsService.getPqrss();
        model.addAttribute("respuestas", respuestas);
        model.addAttribute("pqrss", pqrss);
        return "respuesta/all";
    }

    @GetMapping("/respuesta/new")
    public String showNewRespuesta(Model model){
        model.addAttribute("respuesta", new Respuesta());
        model.addAttribute("pqrss", pqrsService.getPqrss());
        return "respuesta/new";
    }

    @PostMapping("/respuesta/save")
    public String newRespuesta(Respuesta respuesta){
        respuestaService.saveRespuesta(respuesta);
        return "redirect:/pqrs/todo";
    }

    @GetMapping("/respuesta/update/{id}")
    public String showUpdateRespuesta(@PathVariable Integer id, Model model){
        model.addAttribute("respuesta", respuestaService.getRespuesta(id));
        model.addAttribute("pqrss", pqrsService.getPqrss());
        return "respuesta/update";
    }

    @PostMapping("/respuesta/update/{id}")
    public String updateRespuesta(@PathVariable Integer id, Respuesta respuesta){
        respuesta.setId(id);
        respuestaService.updateRespuesta(respuesta);
        return "redirect:/respuesta/all";
    }


    @GetMapping("/respuesta/delete/{id}")
    public String deleteRespuesta(@PathVariable Integer id){
        respuestaService.deleteRespuesta(id);
        return "redirect:/respuesta/all";
    }

}
