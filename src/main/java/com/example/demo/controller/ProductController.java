/*package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String GetProducts(Model model){
        List<Product> listProducts = productRepository.findAll();
        model.addAttribute("products", listProducts);
        return "Product/Product";
    }
}
*/