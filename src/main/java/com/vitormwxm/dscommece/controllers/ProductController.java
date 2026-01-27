package com.vitormwxm.dscommece.controllers;

import com.vitormwxm.dscommece.dto.ProductDTO;
import com.vitormwxm.dscommece.entities.Product;
import com.vitormwxm.dscommece.repository.ProductRepository;
import com.vitormwxm.dscommece.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController// informando que é uma controller do tipo APIRest
@RequestMapping( value = "products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}") // informa que é uma requisição GET, que deve utilizar um id para o produto
    public ProductDTO findById(@PathVariable Long id) { //PathVariable vai casar o caminho completo
        ProductDTO dto = service.findById(id);
        return dto;
    }

    @GetMapping// informa que é uma requisição GET, que deve utilizar um id para o produto
    public Page<ProductDTO> findAll(Pageable pageable) { //PathVariable vai casar o caminho completo
        Page<ProductDTO> dto = service.findAll(pageable);
        return dto;
    }
}
