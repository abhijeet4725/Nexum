package com.abhijeet.nexum.payment.repo;

import com.abhijeet.nexum.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<UUID, Payment> {
}
