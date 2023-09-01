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
    //estou testando o método objectNotFound que criei na classe controllerException handler
    //aqui eu testo se a exceção existe
assertNotNull(response);
//em seguida testo se essa exceção existe no corpo da requisição
assertNotNull(response.getBody());

//aqui testo se de fato o statos code a ser lançado é o HTTP NotFound
assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//aqui verifico se a classe é de fato a responceEntity
assertEquals(ResponseEntity.class, response.getClass());
//aqui verifico se a classe responsável pelas mensagens de erro é a responsável por passar as mensagens de erro no corpo da requisição
    assertEquals(StandardError.class, response.getBody().getClass());
    //agora quero testar se essas mensagens de erro são de fato as mesmas.

    assertEquals(PRODUTO_NAO_ENCONTRADO, response.getBody().getError());
    //quero saber se o statos passado no corpo é realmente o 404
    assertEquals(404, response.getBody().getStatus());
    //quero garantir que o caminho passado no corpo seja diferente do que passei
assertNotEquals("/product/2", response.getBody().getPath());
//quero verificar que o horário de agora não seja igual ao passado no corpo da requisição
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
