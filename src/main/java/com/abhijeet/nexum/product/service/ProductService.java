package com.abhijeet.nexum.product.service;

import com.abhijeet.nexum.product.domain.dtos.*;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponseDto addProduct(CreateProductRequestDto createProductDto);
    ProductResponseDto updateProduct(UpdateProductRequestDto updateProductRequestDto);
    List<ProductResponseDto> getAllProducts();
    void deleteProduct(UUID productId);
}
