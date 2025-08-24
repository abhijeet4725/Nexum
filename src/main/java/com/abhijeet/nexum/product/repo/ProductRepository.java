package com.abhijeet.nexum.product.repo;

import com.abhijeet.nexum.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<UUID, Product> {

}
