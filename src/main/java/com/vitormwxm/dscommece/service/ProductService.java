package com.vitormwxm.dscommece.service;

import com.vitormwxm.dscommece.dto.ProductDTO;
import com.vitormwxm.dscommece.entities.Product;
import com.vitormwxm.dscommece.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    // retorna uma DTO a partir do ID
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice()
        , product.getImgUrl());
        return dto;
    }
}
