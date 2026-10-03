package com.krishivaani.repository;

import com.krishivaani.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByBuyerName(String buyerName);

    List<Order> findByCropId(Long cropId);

}