package com.abhijeet.nexum.order.repo;

import com.abhijeet.nexum.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<UUID, Order> {
}
