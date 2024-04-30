package com.invio.shopping.util;

import com.invio.shopping.dto.BasketResponse;
import com.invio.shopping.dto.OrderResponse;
import com.invio.shopping.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDtoConvertion {

    public static List<OrderResponse> convertOrderList(List<Order> orders){
        List<OrderResponse> orderResponses = new ArrayList<>();
        orders.stream().forEach(order -> orderResponses.add(new OrderResponse(order.getId()
                ,OrderProductDtoConvertion.convertOrderPrList(order.getBasket().getProductList()), order.getBasket().getTotalPrice()
                )));
        return orderResponses;
    }

    public static OrderResponse convertOrder(Order order){
        return new OrderResponse(order.getId()
                ,OrderProductDtoConvertion.convertOrderPrList(order.getBasket().getProductList()), order.getBasket().getTotalPrice()
        );
    }
}
