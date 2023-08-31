package com.catalisa.sistemaEstoque.service;

import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.repository.ProductRepository;
import com.catalisa.sistemaEstoque.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Impl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
return  obj.orElseThrow(() -> new ObjectNotFoundException("produto não encontrado"));

    }
}
