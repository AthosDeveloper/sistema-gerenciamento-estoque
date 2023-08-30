package com.catalisa.sistemaEstoque.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "tb_products")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"description", "quantity"})
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
