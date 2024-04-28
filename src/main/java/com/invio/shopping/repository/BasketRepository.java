package com.invio.shopping.repository;

import com.invio.shopping.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {
}
