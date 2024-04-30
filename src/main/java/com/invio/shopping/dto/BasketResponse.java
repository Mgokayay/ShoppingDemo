package com.invio.shopping.dto;

import com.invio.shopping.entity.Product;

import java.util.List;

public record BasketResponse(Long id,List<ProductResponse> productList, List<SummaryResponse> summary,Double total_price) {
}
