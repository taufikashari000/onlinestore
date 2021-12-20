package com.onlinestore.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EditProductRequest {
    @NotNull private Long id;
    @NotNull private String name;
    @NotNull private Long price;
    @NotNull private Integer quantity;
}
