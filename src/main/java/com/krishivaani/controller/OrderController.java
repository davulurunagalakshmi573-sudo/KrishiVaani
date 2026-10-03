package com.krishivaani.controller;

import com.krishivaani.entity.Order;
import com.krishivaani.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@Valid @RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return orderService.updateOrderStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully!";
    }

    @GetMapping("/buyer/{buyerName}")
    public List<Order> getOrdersByBuyer(
            @PathVariable String buyerName) {

        return orderService.getOrdersByBuyer(buyerName);
    }

    @GetMapping("/crop/{cropId}")
    public List<Order> getOrdersByCrop(
            @PathVariable Long cropId) {

        return orderService.getOrdersByCrop(cropId);
    }
}