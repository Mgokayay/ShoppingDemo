package com.invio.shopping.util;

import com.invio.shopping.dto.OrderProductResponse;
import com.invio.shopping.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderProductDtoConvertion {


    public static List<OrderProductResponse> convertOrderPrList(List<Product> products){
        List<OrderProductResponse> orderProductResponses = new ArrayList<>();
        products.stream().forEach(product -> orderProductResponses.add(new OrderProductResponse(product.getId(),
                product.getName(),product.getPrice(),product.getCount())));
        return orderProductResponses;
    }

    public static OrderProductResponse convertOrderPr(Product product){
        return new OrderProductResponse(product.getId(),
                product.getName(),product.getPrice(),product.getCount());
    }
}
