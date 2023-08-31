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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
@Test
void returnAListOfDTO_whenFindAll(){
when(service.findAll())
        .thenReturn(List.of(product));
when(any(), any())
        .thenReturn(dto2);
ResponseEntity<List<ProductDTO2>> responce = controller.findAll();
assertNotNull(responce);
assertNotNull(responce.getBody());

assertEquals(HttpStatus.OK, responce.getStatusCode());
    assertEquals(ResponseEntity.class, responce.getClass());

    assertEquals(ArrayList.class, responce.getBody().getClass());

    assertEquals(ProductDTO.class, responce.getBody().get(INDEX).getClass());
    assertEquals(NAME, responce.getBody().get(INDEX).getName());

    assertEquals(DESCRIPTION, responce.getBody().get(INDEX).getDescription());
    assertEquals(PRICE, responce.getBody().get(INDEX).getPrice());
assertEquals(QUANTITY, responce.getBody().get(INDEX).getQuantity());
}
@Test
void  returnCreated_whenCreate(){
when(service.create(any()))
        .thenReturn(product);
ResponseEntity<ProductDTO> responce = controller.create(productDTO);
assertEquals(ResponseEntity.class, responce.getClass());
assertEquals(HttpStatus.CREATED, responce.getStatusCode());
assertNotNull(responce.getHeaders().get("Location"));
}
@Test
void returnSuccess_whenUpdateProduct(){
when(service.update(productDTO))
        .thenReturn(product);
when(mapper.map(any(), any()))
        .thenReturn(productDTO);
ResponseEntity<ProductDTO> responce =controller.update(ID, productDTO);
    assertNotNull(responce);
    assertNotNull(responce.getBody());
    assertEquals(HttpStatus.OK, responce.getStatusCode());

    assertEquals(ResponseEntity.class, responce.getClass());
    assertEquals(ProductDTO.class, responce.getBody().getClass());

    assertEquals(ID, responce.getBody().getId());
    assertEquals(NAME, responce.getBody().getName());
    assertEquals(DESCRIPTION, responce.getBody().getDescription());
    assertEquals(PRICE, responce.getBody().getPrice());

    assertEquals(QUANTITY, responce.getBody().getQuantity());


}
@Test
void returnSuccess_whenDeletAProduct(){
doNothing().when(service).delete(anyLong());
ResponseEntity<ProductDTO> responce = controller.delet(ID);
    assertNotNull(responce);
assertEquals(ResponseEntity.class, responce.getBody().getClass());
assertEquals(HttpStatus.NO_CONTENT, responce.getStatusCode());
verify(service, times(1)).delete(anyLong());

}
    private  void startProduct(){

        product = new Product(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
        productDTO = new ProductDTO(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
        dto2 = new ProductDTO2(NAME, DESCRIPTION, PRICE, QUANTITY);

    }

}
