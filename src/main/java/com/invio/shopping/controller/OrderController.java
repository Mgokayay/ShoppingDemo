package com.invio.shopping.controller;

import com.invio.shopping.dto.OrderResponse;
import com.invio.shopping.entity.Basket;
import com.invio.shopping.entity.Order;
import com.invio.shopping.service.BasketService;
import com.invio.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final BasketService basketService;
    @Autowired
    public OrderController(OrderService orderService, BasketService basketService) {
        this.orderService = orderService;
        this.basketService = basketService;
    }

    @GetMapping("/")
    public List<OrderResponse> findAll(){
        return orderService.findAll();
    }

    @PostMapping("/{basketId}")
    public OrderResponse save(@RequestBody Order order,@PathVariable Long basketId){
        Basket basket=basketService.findByBasketId(basketId);
        basket.setOrder(order);
        order.setBasket(basket);
        return  orderService.save(order);
    }
}
