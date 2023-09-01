package com.catalisa.sistemaEstoque.controller;

import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO;
import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO2;
import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.service.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "produtos")
@RequestMapping(value = "/product")
@RestController
public class ProductController {

    private static final String ID = "{id}";
    @Autowired
    private ProductServiceImpl service;
    @Autowired
    private ModelMapper mapper;
   @Operation(summary = "busca todos os produtos", method = "GET")
   @ApiResponses(value = @ApiResponse(responseCode = "200",  description = "busca realizada com sucesso "))
    @GetMapping
    public ResponseEntity<List<ProductDTO2>> findAll(){

        return ResponseEntity.ok().body(service.findAll().stream()
                .map(product -> mapper.map(product, ProductDTO2.class))
                .collect(Collectors.toList()));

    }
    @Operation(summary = "busca um produto por um id específico", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "busca realizada com sucesso"))
    @GetMapping(value = ID)
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
return ResponseEntity.ok().body(mapper.map(service.findById(id), ProductDTO.class));
    }
    @Operation(summary = "cadastra um produto no sistema", method = "POST")
    @ApiResponses(value = @ApiResponse(responseCode = "201", description = "produto encontrado"))

@PostMapping
public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO obj){
    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path(ID)
            .buildAndExpand(service.create(obj).getId())
            .toUri();
    return  ResponseEntity.created(uri).build();
}
@Operation(summary = "alterar um produto pelo id", method = "PUT")
@ApiResponses(value = @ApiResponse(responseCode = "200"))
@PutMapping(value = ID)
public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO obj){
obj.setId(id);
//só para garantir realmente que o id passado pela requisição é essa mesmo.
return  ResponseEntity.ok().body(mapper.map(service.update(obj), ProductDTO.class));
}
@Operation(summary = "deleta um produto do sistema pelo id")
@ApiResponses(value = @ApiResponse(responseCode = "204", description = "produto deletado com sucesso"))
@DeleteMapping(value = ID)
public ResponseEntity<ProductDTO> delet(@PathVariable Long id){
service.delete(id);
return  ResponseEntity.noContent().build();
}
}
