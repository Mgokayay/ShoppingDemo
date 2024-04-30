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

import java.util.Iterator;
import java.util.Objects;
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
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new CommonException("BasketId is not exist with given id " + basketId, HttpStatus.NOT_FOUND));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CommonException("ProductId is not exist with given id : " + productId, HttpStatus.NOT_FOUND));

        basket.getProductList().add(product);
        product.setBasket(basket);

        if (product.getCount() == null) {
            product.setCount(1);
        } else {
            product.setCount(product.getCount() + 1);
        }


        Double totalPrice = 0.0;
        for (Product product1 : basket.getProductList()) {
            totalPrice += product1.getPrice() * product1.getCount();
        }
        basket.setTotalPrice(totalPrice);


        basketRepository.save(basket);

        return BasketDtoConvertion.convertBasket(basket);
    }

    @Override
    public BasketResponse removeToCart(Long basketId, Long productId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new CommonException("BasketId is not exist with given id " + basketId, HttpStatus.NOT_FOUND));

        boolean removed = false;
        Iterator<Product> iterator = basket.getProductList().iterator();
        while (iterator.hasNext()) {
            Product product1 = iterator.next();
            if (product1.getId() == productId) {
                if (product1.getCount() == 1) {
                    iterator.remove();
                    removed = true;
                } else {
                    product1.setCount(product1.getCount() - 1);
                    removed = true;
                }
                break;
            }
        }

        if (!removed) {
            throw new CommonException("ProductId is not exist with given id : " + productId, HttpStatus.NOT_FOUND);
        }

        // Toplam fiyatı güncelle
        double totalPrice = 0.0;
        for (Product product : basket.getProductList()) {
            totalPrice += product.getPrice() * product.getCount();
        }
        basket.setTotalPrice(totalPrice);

        basketRepository.save(basket);
        return BasketDtoConvertion.convertBasket(basket);
    }

    @Override
    public Basket findByBasketId(Long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new CommonException("BasketId is not exist with given id : " + id
                        , HttpStatus.NOT_FOUND));

    }


}
