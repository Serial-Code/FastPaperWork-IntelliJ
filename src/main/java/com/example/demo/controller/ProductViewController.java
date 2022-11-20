package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/all")
    public String getProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "product/all";
    }

    @GetMapping("/product/new")
    public String showNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/new";
    }

    @PostMapping("/product/save")
    public String newProduct(Product product){
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/product/update/{id}")
    public String showUpdateProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        return "product/update";
    }

    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable Long id, Product product){
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/product/all";
    }


}
