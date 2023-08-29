package com.catalisa.sistemaEstoque.controller;

import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = service.findAll();
   return ResponseEntity.ok().body(products);
    }
}
