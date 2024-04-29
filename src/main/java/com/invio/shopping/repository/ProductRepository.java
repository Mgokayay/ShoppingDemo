package com.invio.shopping.repository;

import com.invio.shopping.dto.ProductResponse;
import com.invio.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByAsc();

    @Query("SELECT p FROM Product p ORDER BY p.price DESC ")
    List<Product> sortByDesc();
}
