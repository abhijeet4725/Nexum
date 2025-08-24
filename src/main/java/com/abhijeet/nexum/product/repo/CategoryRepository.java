package com.abhijeet.nexum.product.repo;

import com.abhijeet.nexum.product.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<UUID, Category> {

}
