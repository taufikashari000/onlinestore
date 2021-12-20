package com.onlinestore.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private Long price;
    private Integer quantity;

    public ProductDto() {

    }

    public ProductDto(Long id, String name, Long price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
