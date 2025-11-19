package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    Order updateOrder(int id, Order order);

    Order getOrderById(int id);

    List<Order> getAllOrders();

    List<Order> getOrdersByStatus(String status);

    List<Order> getOrdersByPaymentStatus(String paymentStatus);

    void softDeleteOrder(int id);

    Order restoreOrder(int id);

    void deleteOrderPermanent(int id);
}

