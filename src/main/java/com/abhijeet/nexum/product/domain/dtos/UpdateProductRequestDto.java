package com.abhijeet.nexum.product.domain.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class UpdateProductRequestDto {
    private String title;

    private String description;

    @Positive
    private BigDecimal price;

    @DecimalMin(value = "0.0")
    private BigDecimal discount;

    @Positive
    private long categoryId;
}
