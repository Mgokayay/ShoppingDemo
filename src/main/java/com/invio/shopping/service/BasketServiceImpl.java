package com.invio.shopping.service;

import com.invio.shopping.dto.BasketResponse;
import com.invio.shopping.entity.Basket;
import com.invio.shopping.entity.Product;
import com.invio.shopping.exceptions.CommonException;
import com.invio.shopping.repository.BasketRepository;
import com.invio.shopping.repository.ProductRepository;
import com.invio.shopping.util.BasketDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService{

    private final BasketRepository basketRepository;

    private final ProductRepository productRepository;
    @Override
    public BasketResponse save(Basket basket) {
        basketRepository.save(basket);
        return BasketDtoConvertion.convertBasket(basket);
    }

    @Override
    public BasketResponse findById(Long id) {
        Optional<Basket> basketOptional = basketRepository.findById(id);
        if(basketOptional.isPresent()){
            return BasketDtoConvertion.convertBasket(basketOptional.get());
        }
        throw new CommonException("Basket is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public BasketResponse delete(Long id) {
        Optional<Basket> basketOptional = basketRepository.findById(id);
        if(basketOptional.isPresent()){
            basketRepository.delete(basketOptional.get());
            return BasketDtoConvertion.convertBasket(basketOptional.get());
        }
        throw new CommonException("Basket is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public BasketResponse addToCart(Long basketId, Long productId) {
        Basket basket = basketRepository.findById(basketId).orElseThrow(
                ()->new CommonException("BasketId is not exist with given id " + basketId,HttpStatus.NOT_FOUND)

        );
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new CommonException("ProductId is not exist with given id " + productId,HttpStatus.NOT_FOUND)
        )  ;

        basket.getProductList().add(product);
        product.setBasket(basket);
        basketRepository.save(basket);
        return BasketDtoConvertion.convertBasket(basket);
    }


}
