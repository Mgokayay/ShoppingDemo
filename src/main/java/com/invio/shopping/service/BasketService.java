package com.invio.shopping.service;

import com.invio.shopping.entity.Basket;

public interface BasketService {

    Basket save(Basket basket);

    Basket findById(Long id);

    Basket delete(Long id);


}
