package com.invio.shopping.service;

import com.invio.shopping.dto.OrderResponse;
import com.invio.shopping.entity.Order;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAll();

    OrderResponse save(Order order);


}
