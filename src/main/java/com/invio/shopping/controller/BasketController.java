package com.invio.shopping.controller;

import com.invio.shopping.dto.BasketResponse;
import com.invio.shopping.entity.Basket;
import com.invio.shopping.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;
    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }
    @PostMapping
    public BasketResponse save(@RequestBody Basket basket){
        return basketService.save(basket);
    }

    @GetMapping("/{id}")
    public BasketResponse findById(@PathVariable Long id){
        return basketService.findById(id);
    }

    @DeleteMapping("/{id}")
    public BasketResponse delete(@PathVariable Long id){
        return  basketService.delete(id);
    }

    @PostMapping("/{basketId}/{productId}")
    public BasketResponse addToCart(@PathVariable Long basketId,@PathVariable Long productId ){
        return basketService.addToCart(basketId, productId);
    }

    @DeleteMapping("/{basketId}/{productId}")
    public BasketResponse removeToCart(@PathVariable Long basketId,@PathVariable Long productId){
        return basketService.removeToCart(basketId, productId);
    }


}
