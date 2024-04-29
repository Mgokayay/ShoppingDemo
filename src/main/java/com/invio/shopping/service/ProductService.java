package com.invio.shopping.service;

import com.invio.shopping.dto.ProductResponse;
import com.invio.shopping.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponse save(Product product);

    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    ProductResponse delete(Long id);

    List<ProductResponse> sortByAsc();

    List<ProductResponse> sortByDesc();
}
