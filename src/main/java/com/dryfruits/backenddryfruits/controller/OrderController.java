package com.dryfruits.backenddryfruits.controller;

import com.dryfruits.backenddryfruits.model.Order;
import com.dryfruits.backenddryfruits.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/status")
    public List<Order> getOrdersByStatus(@RequestParam String status) {
        return orderService.getOrdersByStatus(status);
    }

    @GetMapping("/payment-status")
    public List<Order> getOrdersByPaymentStatus(@RequestParam String paymentStatus) {
        return orderService.getOrdersByPaymentStatus(paymentStatus);
    }

    @DeleteMapping("/soft-delete/{id}")
    public String softDeleteOrder(@PathVariable int id) {
        orderService.softDeleteOrder(id);
        return "Order moved to trash successfully!";
    }

    @PutMapping("/restore/{id}")
    public Order restoreOrder(@PathVariable int id) {
        return orderService.restoreOrder(id);
    }

    @DeleteMapping("/delete-permanent/{id}")
    public String deletePermanent(@PathVariable int id) {
        orderService.deleteOrderPermanent(id);
        return "Order permanently deleted!";
    }
}


