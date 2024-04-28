package com.invio.shopping.controller;

import com.invio.shopping.dto.ProductResponse;
import com.invio.shopping.entity.Product;
import com.invio.shopping.service.ProductService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductResponse> findAll(){

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public ProductResponse save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public ProductResponse delete(@PathVariable Long id){
        return productService.delete(id);
    }

    @GetMapping("/product/asc")
    public List<ProductResponse> sortByAsc(){
        return productService.sortByAsc();
    }

    @GetMapping("/product/desc")
    public List<ProductResponse> sortByDesc(){
        return productService.sortByDesc();
    }
}
