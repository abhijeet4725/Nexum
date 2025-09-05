package com.abhijeet.nexum.product.controller;

import com.abhijeet.nexum.product.domain.dtos.CreateProductRequestDto;
import com.abhijeet.nexum.product.domain.dtos.ProductResponseDto;
import com.abhijeet.nexum.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/add")
    public ProductResponseDto addProduct(@Valid @RequestBody CreateProductRequestDto dto){
        return productService.addProduct(dto);
    }
}
