package com.abhijeet.nexum.product.service;

import com.abhijeet.nexum.product.domain.dtos.CreateProductRequestDto;
import com.abhijeet.nexum.product.domain.dtos.CreateProductResponseDto;
import com.abhijeet.nexum.product.domain.dtos.UpdateProductRequestDto;
import com.abhijeet.nexum.product.domain.dtos.UpdateProductResponseDto;

public interface ProductService {
    CreateProductResponseDto addProduct(CreateProductRequestDto createProductDto);
    UpdateProductResponseDto updateProduct(UpdateProductRequestDto updateProductRequestDto);
}
