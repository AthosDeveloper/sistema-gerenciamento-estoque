package com.catalisa.sistemaEstoque.servicesImpl;

import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO;
import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO2;
import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.repository.ProductRepository;
import com.catalisa.sistemaEstoque.service.ProductService;
import com.catalisa.sistemaEstoque.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class ProductServiceImplTest {
    private static  final Long ID = 1L;
private static  final Long INDEX = 0L;
private Static final String NAME = "computador";
private  static  final  String DESCRIPTION = "computador de mesa";
private  static  final BigDecimal PRICE = 4893;
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
private  void startProduct(){
product = new Product(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
ProductDTO = new ProductDTO(ID, NAME, DESCRIPTION, PRICE, QUANTITY);
dto2 = new ProductDTO2(NAME, DESCRIPTION, PRICE, QUANTITY);
optionalProduct = Optional.of(new Product(ID, NAME, DESCRIPTION, PRICE, QUANTITY));
}
}

