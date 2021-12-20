package com.onlinestore.payload;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductRequest {
    @NotNull private String name;
    @NotNull private Long price;
    @NotNull private Integer quantity;
}
