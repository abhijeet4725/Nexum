package com.abhijeet.nexum.product.mapper;

import com.abhijeet.nexum.product.domain.Product;
import com.abhijeet.nexum.product.domain.dtos.CreateProductRequestDto;
import com.abhijeet.nexum.product.domain.dtos.ProductResponseDto;
import com.abhijeet.nexum.product.domain.dtos.UpdateProductRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ProductMapper {

    // Request → Entity
    Product toEntity(CreateProductRequestDto createProductRequestDto);
    Product toEntity(UpdateProductRequestDto updateProductRequestDto);

    // Entity → Response DTO
    ProductResponseDto toResponseDto(Product product);
    // For returning a list
    List<ProductResponseDto> toResponseDtoList(List<Product> products);
}
