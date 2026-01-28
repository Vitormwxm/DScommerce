package com.vitormwxm.dscommece.controllers;

import com.vitormwxm.dscommece.dto.ProductDTO;
import com.vitormwxm.dscommece.entities.Product;
import com.vitormwxm.dscommece.repository.ProductRepository;
import com.vitormwxm.dscommece.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController// informando que é uma controller do tipo APIRest
@RequestMapping( value = "products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}") // informa que é uma requisição GET, que deve utilizar um id para o produto
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) { //PathVariable vai casar o caminho completo
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping// informa que é uma requisição GET, que deve utilizar um id para o produto
    public Page<ProductDTO> findAll(Pageable pageable) { //PathVariable vai casar o caminho completo
        Page<ProductDTO> dto = service.findAll(pageable);
        return dto;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO productDTO) { //PathVariable vai casar o caminho completo
        ProductDTO dto = service.insert(productDTO);

        // boas práticas para retornar código 201
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}") // informa que é uma requisição GET, que deve utilizar um id para o produto
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) { //PathVariable vai casar o caminho completo
        ProductDTO dto = service.update(id, productDTO);
        return ResponseEntity.ok(dto);
    }


}
