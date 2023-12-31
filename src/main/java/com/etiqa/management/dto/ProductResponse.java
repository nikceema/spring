package com.etiqa.management.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private String category;
    private String titleName;
    private Integer quantity;
    private BigDecimal price;
}
