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

}
