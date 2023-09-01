package com.catalisa.sistemaEstoque.controllers.exception;

import com.catalisa.sistemaEstoque.controller.exceptions.ControllerExceptionHandler;
import com.catalisa.sistemaEstoque.controller.exceptions.StandardError;
import com.catalisa.sistemaEstoque.service.exceptions.DataIntegrityViolationException;
import com.catalisa.sistemaEstoque.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ControllerExceptionHandlerTest {

    private  static  final String PRODUTO_NAO_ENCONTRADO = "produto não encontrado";
    private static final String NOME_DO_PRODUTO_JA_CADASTRADO_NO_SISTEMA = "nome do produto já cadastrado no sistema";
@InjectMocks
private ControllerExceptionHandler controllerException;
@BeforeEach
    public void setUp(){
    MockitoAnnotations.openMocks(this);

}
@Test
void  returnAResponceEntity_whenObjectNotFound(){
    ResponseEntity<StandardError> response = controllerException
            .objectNotFound(new ObjectNotFoundException(PRODUTO_NAO_ENCONTRADO), new MockHttpServletRequest());
assertNotNull(response);
assertNotNull(response.getBody());

assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
assertEquals(ResponseEntity.class, response.getClass());
    assertEquals(StandardError.class, response.getBody().getClass());
    assertEquals(PRODUTO_NAO_ENCONTRADO, response.getBody().getError());
    assertEquals(404, response.getBody().getStatus());
assertNotEquals("/product/2", response.getBody().getPath());
assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());


}
@Test
    void returnIntegrityViolationException_whenInstanciating(){
ResponseEntity<StandardError> response = controllerException
        .dataIntegrityViolationException(
                new DataIntegrityViolationException(NOME_DO_PRODUTO_JA_CADASTRADO_NO_SISTEMA),
new MockHttpServletRequest());




    assertNotNull(response);
    assertNotNull(response.getBody());

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals(ResponseEntity.class, response.getClass());
assertEquals(StandardError.class, response.getBody().getClass());
assertEquals(NOME_DO_PRODUTO_JA_CADASTRADO_NO_SISTEMA, response.getBody().getError());
assertEquals(400, response.getBody().getStatus());

}
}
