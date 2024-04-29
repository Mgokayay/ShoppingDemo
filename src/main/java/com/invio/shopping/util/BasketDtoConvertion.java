package com.invio.shopping.util;

import com.invio.shopping.dto.BasketResponse;
import com.invio.shopping.entity.Basket;

import java.util.ArrayList;
import java.util.List;

public class BasketDtoConvertion {


    public static List<BasketResponse> convertBasketList(List<Basket> baskets){
        List<BasketResponse> basketResponses = new ArrayList<>();
        baskets.stream().forEach(basket -> basketResponses.add(new BasketResponse(basket.getId(),
                ProductDtoConvertion.convertProductList(basket.getProductList()))));
        return basketResponses;
    }

    public static BasketResponse convertBasket(Basket basket){
        return new BasketResponse(basket.getId(), ProductDtoConvertion.convertProductList(basket.getProductList()));
    }
}
