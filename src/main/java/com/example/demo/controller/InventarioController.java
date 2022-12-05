package com.example.demo.controller;

import com.example.demo.DTO.ReportInventarioDTO;
import com.example.demo.entity.Inventario;
import com.example.demo.enums.TipoReporteEnum;
import com.example.demo.service.InventarioService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ReportInventarioService;
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
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ReportInventarioService reportInventarioService;

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

    @GetMapping("/inventario/report")
    public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) throws JRException, IOException, SQLException {
        ReportInventarioDTO dto = reportInventarioService.obtenerReporteInventario(params);

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