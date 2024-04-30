package com.invio.shopping.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product" , schema = "shopping")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "description")
    private String description;

    @ElementCollection
    @Column(name = "features")
    private List<String> features;

    @Column(name = "availability")
    private Boolean availability;

    @Column(name = "stock")
    private Double stock;

    @ElementCollection
    @Column(name = "dimensions")
    private Map<String,Integer> dimensions;

    @Column(name = "weight")
    private Double weight;

    @ElementCollection
    @Column(name = "colors")
    private List<String> colors;

    private Integer count=0;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Basket basket;



}

