package com.onlinestore.service;

import com.onlinestore.dto.ProductDto;
import com.onlinestore.model.Product;
import com.onlinestore.payload.CreateProductRequest;
import com.onlinestore.payload.EditProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProductService {
    List<ProductDto> getAllProduct();
    Product findById(Long id);
    Product saveNew(CreateProductRequest request);
    Product editProduct(Long id, EditProductRequest request);
    void deleteProduct(Long id);
    String buyProduct(Long id, Integer quantity);
}
