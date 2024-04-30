package com.invio.shopping.service;

import com.invio.shopping.dto.OrderResponse;
import com.invio.shopping.entity.Order;
import com.invio.shopping.repository.OrderRepository;
import com.invio.shopping.util.OrderDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public List<OrderResponse> findAll() {

        return OrderDtoConvertion.convertOrderList(orderRepository.findAll());
    }

    @Override
    public OrderResponse save(Order order) {
        orderRepository.save(order);
        return OrderDtoConvertion.convertOrder(order);
    }
}
