package com.catalisa.sistemaEstoque.config;

import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private ProductRepository repository;
    @Bean
    public  void startDB(){
       Product product1 = new Product(null, "playstation4", "jogue em seu console", new BigDecimal("3.546"), 1);
   Product product2 = new Product(null, "computador", "um computador de qualidade de intelcore i 9", new BigDecimal("6.546.352"), 1);
   repository.saveAll(List.of(product1, product2));
    }
}
