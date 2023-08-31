package com.catalisa.sistemaEstoque.service;

import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO;
import com.catalisa.sistemaEstoque.model.Product;

import java.util.List;

public interface ProductService {
Product findById(Long id);
List<Product> findAll();
Product create(ProductDTO obj);
Product update(ProductDTO obj);
void  delete(Long id);
}
