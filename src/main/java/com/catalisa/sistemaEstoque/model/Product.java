package com.catalisa.sistemaEstoque.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "tb_products")
@Entity
public class Product {
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private  String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
