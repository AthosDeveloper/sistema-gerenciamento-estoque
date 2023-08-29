package com.catalisa.sistemaEstoque.repository;

import com.catalisa.sistemaEstoque.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
