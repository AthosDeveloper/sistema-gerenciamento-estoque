package com.catalisa.sistemaEstoque.controllers;

import com.catalisa.sistemaEstoque.controller.ProductController;
import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO;
import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO2;
import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    private static  final Long ID = 1L;
    private static  final Integer INDEX = 0;
    private static final String NAME = "computador";
    private  static  final  String DESCRIPTION = "computador de mesa";
    private  static  final BigDecimal PRICE = new BigDecimal("4893.3512");
    private  static  final  Integer QUANTITY = 2;
private Product product = new Product();
    private ProductDTO productDTO = new ProductDTO();
    private ProductDTO2 dto2 = new ProductDTO2();
@InjectMocks
private ProductController controller;
@Mock
    private ProductServiceImpl service;
@Mock
    private ModelMapper mapper;
@BeforeEach
void  setUp(){
    MockitoAnnotations.openMocks(this);
    startProduct();
}
@Test
void returnSuccess_whenFindById(){
when(service.findById(anyLong()))
        .thenReturn(product);
when(mapper.map(any(), any()))
        .thenReturn(productDTO);
    ResponseEntity<ProductDTO> responce = controller.findById(ID);
assertNotNull(responce);
assertNotNull(responce.getBody());
assertEquals(ResponseEntity.class, responce.getClass());
    assertEquals(ProductDTO.class, responce.getBody().getClass());
    assertEquals(ID, responce.getBody().getId());
    assertEquals(NAME, responce.getBody().getName());
    assertEquals(DESCRIPTION, responce.getBody().getDescription());
    assertEquals(PRICE, responce.getBody().getPrice());

    assertEquals(QUANTITY, responce.getBody().getQuantity());



}
    private  void startProduct(){
        product = new Product(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
        productDTO = new ProductDTO(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
        dto2 = new ProductDTO2(NAME, DESCRIPTION, PRICE, QUANTITY);

    }

}
