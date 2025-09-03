package com.abhijeet.nexum.product.domain.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CreateProductRequestDto {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal discount;

    @NotNull
    @Positive
    private long categoryId;
}
    
