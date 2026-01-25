package com.vitormwxm.dscommece.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// informando que é uma controller do tipo APIRest
@RequestMapping( value = "products")
public class ProductController {

    @GetMapping // informa que é uma requisição GET
    public String teste() {
        return "Ola mundo!";
    }
}
