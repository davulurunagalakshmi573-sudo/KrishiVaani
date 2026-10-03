package com.krishivaani.service;

import com.krishivaani.entity.Order;
import com.krishivaani.exception.ResourceNotFoundException;
import com.krishivaani.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        if (order.getStatus() == null || order.getStatus().isBlank()) {
            order.setStatus("PENDING");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order with ID " + id + " not found"));
    }

    public Order updateOrderStatus(Long id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order with ID " + id + " not found"));

        order.setStatus(status);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Order with ID " + id + " not found");
        }

        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByBuyer(String buyerName) {
        return orderRepository.findByBuyerName(buyerName);
    }

    public List<Order> getOrdersByCrop(Long cropId) {
        return orderRepository.findByCropId(cropId);
    }
}