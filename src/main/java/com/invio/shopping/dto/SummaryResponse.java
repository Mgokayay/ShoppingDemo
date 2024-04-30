package com.invio.shopping.dto;

public record SummaryResponse(Long product_id, String product_name, Double total_price, Integer count) {
}
