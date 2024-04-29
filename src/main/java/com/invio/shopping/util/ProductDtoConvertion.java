package com.invio.shopping.util;

import com.invio.shopping.dto.ProductResponse;
import com.invio.shopping.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoConvertion {


    public static List<ProductResponse> convertProductList(List<Product> products){
        List<ProductResponse> productResponses = new ArrayList<>();
        products.stream().forEach(product -> productResponses.add(new ProductResponse(product.getId(),product.getName()
        ,product.getBrand(),product.getCategory(),product.getPrice(),product.getCurrency(),product.getDescription()
        ,product.getFeatures(),product.getAvailability(),product.getStock(),product.getDimensions(),product.getWeight()
        ,product.getColors())));
        return productResponses;
    }

    public static ProductResponse convertProduct(Product product){
        return new ProductResponse(product.getId(),product.getName()
                ,product.getBrand(),product.getCategory(),product.getPrice(),product.getCurrency(),product.getDescription()
                ,product.getFeatures(),product.getAvailability(),product.getStock(),product.getDimensions(),product.getWeight()
                ,product.getColors());
    }

}
