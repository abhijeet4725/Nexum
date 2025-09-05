package com.abhijeet.nexum.product.service;

import com.abhijeet.nexum.product.domain.Category;
import com.abhijeet.nexum.product.domain.Product;
import com.abhijeet.nexum.product.domain.dtos.*;
import com.abhijeet.nexum.product.mapper.ProductMapper;
import com.abhijeet.nexum.product.repo.CategoryRepository;
import com.abhijeet.nexum.product.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository; // Add this


    @PreAuthorize("hasRole('SELLER')")
    @Override
    public ProductResponseDto addProduct(CreateProductRequestDto createProductDto) {
        if (repository.findByTitle(createProductDto.getTitle()).isPresent()){
            throw new IllegalStateException("Product already exists with this title");
        }
        Category category = categoryRepository.findById(createProductDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        Product product = productMapper.toEntity(createProductDto);
        product.setCategory(category);
        Product savedProduct = repository.save(product);
        return productMapper.toResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDto updateProduct(UpdateProductRequestDto updateProductRequestDto) {
        return null;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return List.of();
    }

    @Override
    public void deleteProduct(UUID productId) {

    }
}
