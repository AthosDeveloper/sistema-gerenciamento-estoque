package com.catalisa.sistemaEstoque.controller;

import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/product")
@RestController
public class ProductController {
    private static final String ID = "{id}";
    @Autowired
    private ProductServiceImpl service;
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = service.findAll();
   return ResponseEntity.ok().body(products);
    }
    @GetMapping(value = ID)
    public ResponseEntity<Product> findById(@PathVariable Long id){
return ResponseEntity.ok().body(service.findById(id));
    }

}
