package com.invio.shopping.service;

import com.invio.shopping.dto.BasketResponse;
import com.invio.shopping.entity.Basket;

public interface BasketService {

    BasketResponse save(Basket basket);

    BasketResponse findById(Long id);

    BasketResponse delete(Long id);

    BasketResponse addToCart(Long basketId,Long productId);


}
