package com.invio.shopping.service;

import com.invio.shopping.entity.Basket;
import com.invio.shopping.exceptions.CommonException;
import com.invio.shopping.repository.BasketRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService{

    private final BasketRepository basketRepository;
    @Override
    public Basket save(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public Basket findById(Long id) {
        Optional<Basket> basketOptional = basketRepository.findById(id);
        if(basketOptional.isPresent()){
            return basketOptional.get();
        }
        throw new CommonException("Basket is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Basket delete(Long id) {
        Optional<Basket> basketOptional = basketRepository.findById(id);
        if(basketOptional.isPresent()){
            basketRepository.delete(basketOptional.get());
            return basketOptional.get();
        }
        throw new CommonException("Basket is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }
}
