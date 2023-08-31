package com.catalisa.sistemaEstoque.controller;

import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO;
import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO2;
import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.service.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/product")
@RestController
public class ProductController {

    private static final String ID = "{id}";
    @Autowired
    private ProductServiceImpl service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<ProductDTO2>> findAll(){
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(service.findAll().stream()
                .map(product -> mapper.map(product, ProductDTO2.class))
                .collect(Collectors.toList()));

    }
    @GetMapping(value = ID)
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
return ResponseEntity.ok().body(mapper.map(service.findById(id), ProductDTO.class));
    }
@PostMapping
public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO obj){
    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path(ID)
            .buildAndExpand(service.create(obj).getId())
            .toUri();
    return  ResponseEntity.created(uri).build();
}
@PutMapping(value = ID)
public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO obj){
obj.setId(id);
return  ResponseEntity.ok().body(mapper.map(service.update(obj), ProductDTO.class));
}
@DeleteMapping(value = ID)
public ResponseEntity<ProductDTO> delet(@PathVariable Long id){
service.delete(id);
return  ResponseEntity.noContent().build();
}
}
