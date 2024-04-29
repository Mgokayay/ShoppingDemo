package com.invio.shopping.service;

import com.invio.shopping.dto.ProductResponse;
import com.invio.shopping.entity.Product;
import com.invio.shopping.exceptions.CommonException;
import com.invio.shopping.repository.ProductRepository;
import com.invio.shopping.util.ProductDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public ProductResponse save(Product product) {

        return ProductDtoConvertion.convertProduct(product);
    }

    @Override
    public List<ProductResponse> findAll() {

        return ProductDtoConvertion.convertProductList(productRepository.findAll());
    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){

            return ProductDtoConvertion.convertProduct(productOptional.get());
        }
        throw new CommonException("Product is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public ProductResponse delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            productRepository.delete(productOptional.get());
            return ProductDtoConvertion.convertProduct(productOptional.get());
        }
        throw new CommonException("Product is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<ProductResponse> sortByAsc() {
        return ProductDtoConvertion.convertProductList(productRepository.sortByAsc());
    }

    @Override
    public List<ProductResponse> sortByDesc() {
        return ProductDtoConvertion.convertProductList(productRepository.sortByDesc());
    }
}
