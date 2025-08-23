package com.abhijeet.nexum.order;

import com.abhijeet.nexum.User.Address;
import com.abhijeet.nexum.User.User;
import com.abhijeet.nexum.order.enums.OrderStatus;
//import com.abhijeet.nexum.payment.Payment;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders") // avoid reserved word
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Customer who placed the order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Items in this order
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    // Shipping address (snapshot by reference)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_address_id", nullable = false)
    private Address deliveryAddress;

//    // Payment (1-1)
//    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus status;

    @Column(name = "sub_price", nullable = false)
    private Double subPrice;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "applied_credits")
    private Double appliedCredits;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
