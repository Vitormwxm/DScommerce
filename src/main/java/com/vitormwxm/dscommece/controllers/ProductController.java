package com.vitormwxm.dscommece.controllers;

import com.vitormwxm.dscommece.entities.Product;
import com.vitormwxm.dscommece.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController// informando que é uma controller do tipo APIRest
@RequestMapping( value = "products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping // informa que é uma requisição GET
    public String teste() {
        Optional<Product> result = repository.findById(1L);
        Product product = result.get();
        return product.getName();
    }
}
