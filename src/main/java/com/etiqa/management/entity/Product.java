package com.etiqa.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@MappedSuperclass
public class Product {

    @Column
    private String category;
    @Column
    private String titleName;
    @Column
    private Integer quantity;
    @Column
    private BigDecimal price;
}
