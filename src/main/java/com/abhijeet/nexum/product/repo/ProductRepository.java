package com.abhijeet.nexum.product.repo;

import com.abhijeet.nexum.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findById(UUID id);
    Optional<Product> findByTitle(String title);
}
