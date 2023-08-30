package com.catalisa.sistemaEstoque.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "tb_produtos")
//estou usando data porque não tem muitos atributos, se houvesse não seria tão interessante usar, porque não ficaria tão performático
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private  String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
