package com.abhijeet.nexum.cart.repo;

import com.abhijeet.nexum.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<UUID, Cart> {
}
