package com.invio.shopping.dto;

import com.invio.shopping.entity.Product;

import java.util.List;

public record OrderResponse(Long orderId, List<OrderProductResponse> order_summary, Double total_price) {
}
