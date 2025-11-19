package com.dryfruits.backenddryfruits.serviceImpl;

import com.dryfruits.backenddryfruits.model.Order;
import com.dryfruits.backenddryfruits.repository.OrderRepository;
import com.dryfruits.backenddryfruits.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(int id, Order order) {
        Order existing = getOrderById(id);

        existing.setProductId(order.getProductId());
        existing.setProductVarietyId(order.getProductVarietyId());
        existing.setUnit(order.getUnit());
        existing.setUnitType(order.getUnitType());
        existing.setPrice(order.getPrice());
        existing.setPaymentType(order.getPaymentType());
        existing.setPaymentStatus(order.getPaymentStatus());
        existing.setOrderStatus(order.getOrderStatus());
        existing.setDeliveryDate(order.getDeliveryDate());
        existing.setDeliveredDateAndTime(order.getDeliveredDateAndTime());

        return orderRepository.save(existing);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findByDeletedAtIsNull();
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByOrderStatusAndDeletedAtIsNull(status);
    }

    @Override
    public List<Order> getOrdersByPaymentStatus(String paymentStatus) {
        return orderRepository.findByPaymentStatusAndDeletedAtIsNull(paymentStatus);
    }

    @Override
    public void softDeleteOrder(int id) {
        Order order = getOrderById(id);
        order.setDeletedAt(new Date());
        orderRepository.save(order);
    }

    @Override
    public Order restoreOrder(int id) {
        Order order = getOrderById(id);
        order.setDeletedAt(null);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderPermanent(int id) {
        orderRepository.deleteById(id);
    }
}

