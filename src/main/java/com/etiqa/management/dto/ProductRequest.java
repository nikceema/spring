package com.etiqa.management.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String category;
    private String titleName;
    private Integer quantity;
    private BigDecimal price;
}
