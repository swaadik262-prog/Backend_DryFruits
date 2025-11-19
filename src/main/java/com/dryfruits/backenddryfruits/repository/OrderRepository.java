package com.dryfruits.backenddryfruits.repository;

import com.dryfruits.backenddryfruits.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByDeletedAtIsNull();

    List<Order> findByOrderStatusAndDeletedAtIsNull(String status);

    List<Order> findByPaymentStatusAndDeletedAtIsNull(String paymentStatus);
}

