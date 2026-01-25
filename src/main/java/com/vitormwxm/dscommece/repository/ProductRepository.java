package com.vitormwxm.dscommece.repository;

import com.vitormwxm.dscommece.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
