package com.example.demo.controller;

import com.example.demo.DTO.ReportProductsDTO;
import com.example.demo.DTO.ReportePrecioDolarDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Proveedor;
import com.example.demo.enums.TipoReporteEnum;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProveedorService;
import com.example.demo.service.ReportProductoService;
import com.example.demo.service.ReportePrecioDolarService;
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
public class ProductViewController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ReportProductoService reportProductoService;

    @Autowired
    private ReportePrecioDolarService reportePrecioDolarService;


    @GetMapping("/product/all")
    public String getProducts(Model model) {
        List<Product> products = productService.getProducts();
        List<Proveedor> proveedores = proveedorService.getProveedores();
        model.addAttribute("products", products);
        model.addAttribute("proveedores", proveedores);
        return "product/all";
    }

    @GetMapping("/product/new")
    public String showNewProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("proveedores", proveedorService.getProveedores());
        return "product/new";
    }

    @PostMapping("/product/save")
    public String newProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proveedores", proveedorService.getProveedores());
            return "/product/new";
        }
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/product/update/{id}")
    public String showUpdateProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("proveedores", proveedorService.getProveedores());
        return "product/update";
    }

    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proveedores", proveedorService.getProveedores());
        }
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/all";
    }

    // reporte producto categoria
    @GetMapping("/product/categoria/report")
    public String reporteProducto() {
        return "product/report";
    }


    @GetMapping("/product/report")
    public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) throws JRException, IOException, SQLException {
        ReportProductsDTO dto = reportProductoService.obtenerReporteProducto(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());

        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    // reporte precio dolar por el producto

    @GetMapping("/product/precio_dolar/report")
    public String reportePrecioDolar() {
        return "product/report_dolar";
    }

    @GetMapping("/product_dolar/report")
    public ResponseEntity<Resource> download_precio_dolar(@RequestParam Map<String, Object> params) throws JRException, IOException, SQLException {

            ReportePrecioDolarDTO dto = reportePrecioDolarService.obtenerReportePrecioDolar(params);

            InputStreamResource streamResource = new InputStreamResource(dto.getStream());

            MediaType mediaType = null;
            if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
                mediaType = MediaType.APPLICATION_OCTET_STREAM;
            } else {
                mediaType = MediaType.APPLICATION_PDF;
            }

            return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                    .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);


    }

}