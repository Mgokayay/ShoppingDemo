package com.invio.shopping.dto;

import java.util.List;
import java.util.Map;

public record ProductResponse(Long id, String name, String brand, String category
, Double price, String currency, String description, List<String> features, Boolean availability
, Double stock, Map<String,Integer> dimensions,Double weight,List<String> colors) {
}
