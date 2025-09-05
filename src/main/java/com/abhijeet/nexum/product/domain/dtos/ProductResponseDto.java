package com.abhijeet.nexum.product.domain.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductResponseDto {
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private BigDecimal discount;
    private UUID categoryId;
}
