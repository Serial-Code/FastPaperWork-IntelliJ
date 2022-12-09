package com.example.demo.controller;

import com.example.demo.DTO.ReportPqrsDTO;
import com.example.demo.entity.Pqrs;
import com.example.demo.entity.User;
import com.example.demo.entity.Respuesta;
import com.example.demo.enums.TipoReporteEnum;
import com.example.demo.service.*;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    private UserServices userServices;

    @Autowired
    private ReportPqrsService reportPqrsService;

    @GetMapping("/pqrs/all")
    public String getPqrss(Model model){
        List<Pqrs> Pqrss = pqrsService.getPqrss();
        List<User> Users = userServices.getUsers();
        model.addAttribute("pqrss", Pqrss);
        model.addAttribute("users", Users);
        return "pqrs/all";
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
        pqrsService.deletePqrs(id);
        return "redirect:/pqrs/all";
    }

    @GetMapping("/pqrs/report")
    public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) throws JRException, IOException, SQLException {
        ReportPqrsDTO dto = reportPqrsService.obtenerReportePqrs(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());

        MediaType mediaType = null;
        if(params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())){
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }
}
