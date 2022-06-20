package com.codebuffer.ProductService.command.api.data;

import lombok.Data;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
