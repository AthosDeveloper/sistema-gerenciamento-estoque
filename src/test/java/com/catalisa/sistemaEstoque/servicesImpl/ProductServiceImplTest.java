package com.catalisa.sistemaEstoque.servicesImpl;

import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO;
import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO2;
import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.repository.ProductRepository;
import com.catalisa.sistemaEstoque.service.ProductServiceImpl;
import com.catalisa.sistemaEstoque.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceImplTest {
    private static  final Long ID = 1L;
private static  final Long INDEX = 0L;
private static final String NAME = "computador";
private  static  final  String DESCRIPTION = "computador de mesa";
private  static  final BigDecimal PRICE = new BigDecimal("4893.3512");
private  static  final  Integer QUANTITY = 2;
private  static  final String PRODUTO_NAO_ENCONTRADO = "produto não encontrado";

@InjectMocks
private ProductServiceImpl service;
@Mock
private ProductRepository repository;
@Mock
    private ModelMapper mapper;
private Product product;
private ProductDTO productDTO;
private ProductDTO2 dto2;
private Optional<Product> optionalProduct;
@BeforeEach
void  setUp(){
    MockitoAnnotations.openMocks(this);
startProduct();
}
@Test
public  void ReturnAProductInstance_whenFindById(){
    //repository, busque um id. Se existir, me retorne o produto do tipo optional
when(repository.findById(anyLong()))
        .thenReturn(optionalProduct);
//resposta do produto, receba um serviço buscando um id
Product responce = service.findById(ID);
//garanta que essa resposta exista
assertNotNull(responce);
//garanta que a classe produto seja igual ao service  que estou passando como objeto.
assertEquals(Product.class, responce.getClass());
//garanta que o id seja o mesmo do id passado pelo service
assertEquals(ID, responce.getId());
//garanta que o nome seja o mesmo nome passado pelo service
    assertEquals(NAME, responce.getName());
    //garanta que a descrição seja a mesma passada no service
    assertEquals(DESCRIPTION, responce.getDescription());
    //garanta que  o preço passado seja o mesmo passado no service
    assertEquals(PRICE, responce.getPrice());
//garanta que a quantidade passada seja a mesma passada no service
    assertEquals(QUANTITY, responce.getQuantity());
}
@Test
public void returnObjectNotFoundException_whenFindById(){
    //retorne a exceção personalizada quando buscar o id
when(repository.findById(anyLong()))
        .thenThrow(new ObjectNotFoundException(PRODUTO_NAO_ENCONTRADO));
//service, busque um id que não existe. Java, Capture a exceção que será lançada.
try {
service.findById(ID);
} catch (Exception ex){
//garanta que a exceção objectNotFoundException seja a mesma classe lançada na captura da exceção
assertEquals(ObjectNotFoundException.class, ex.getClass());
//garanta que a mensagem passada na classe objectNotFound seja a mesma da mensagem capturada na exceção
    assertEquals(PRODUTO_NAO_ENCONTRADO, ex.getMessage());
}
}
private  void startProduct(){
product = new Product(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
productDTO = new ProductDTO(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
dto2 = new ProductDTO2(NAME, DESCRIPTION, PRICE, QUANTITY);
optionalProduct = Optional.of(new Product(ID, NAME, DESCRIPTION, PRICE, QUANTITY));
}
}

