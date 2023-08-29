package com.catalisa.sistemaEstoque.service;

import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public List<Product> findAll(){
        return repository.findAll();
    }
}
