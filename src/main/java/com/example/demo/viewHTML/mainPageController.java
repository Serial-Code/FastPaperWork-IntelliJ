package com.example.demo.viewHTML;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageController {

    @GetMapping("/inicio")
    public String main(){
        return "MainPages/mainPage";
    }

    @GetMapping("/catalogo")
    public String catalogue(){
        return "MainPages/catalogePage";
    }

    @GetMapping("/contacto")
    public String contact(){
        return "MainPages/contact";
    }

    @GetMapping("/nosotros")
    public String aboutUs(){
        return "MainPages/aboutUs";
    }


    @GetMapping("/shoppingCar")
    public String shoppinCar(){
        return "MainPages/shoppingCar";
    }

    @GetMapping("/administrador")
    public String homePageA(){
        return "admin/indexCuerpo";
    }

    @GetMapping("/usuario")
    public String homePageU(){
        return "user/indexCuerpoC";
    }

    @GetMapping("/detalle/administrador/dashboard")
    public String detailAdmin(){
        return "admin/dashboard";
    }

    @GetMapping("/detalle/usuario/dashboard")
    public String detailsUser(){
        return "user/dashboard";
    }

}
