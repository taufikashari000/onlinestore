package com.onlinestore.controller;


import com.onlinestore.dto.ProductDto;
import com.onlinestore.model.Product;
import com.onlinestore.payload.BaseResponse;
import com.onlinestore.payload.CreateProductRequest;
import com.onlinestore.payload.EditProductRequest;
import com.onlinestore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/getAllProduct")
    public ResponseEntity<BaseResponse<?>> getAllProduct() {
        List<ProductDto> results = productService.getAllProduct();
        return ResponseEntity.ok(new BaseResponse(results));
    }
    @GetMapping(value = "/{id}/findById")
    public ResponseEntity<BaseResponse<?>> findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(new BaseResponse<>(product));
    }
    @PostMapping(value = "/saveNew")
    public ResponseEntity<BaseResponse<?>> saveNew(@Valid @RequestBody CreateProductRequest request) {
        Product product = productService.saveNew(request);
        return ResponseEntity.ok(new BaseResponse<>(product));
    }
    @PutMapping(value = "/{id}/editProduct")
    public ResponseEntity<BaseResponse<?>> editProduct(@PathVariable("id") Long id, @Valid @RequestBody EditProductRequest request) {
        Product product = productService.editProduct(id, request);
        return ResponseEntity.ok(new BaseResponse<>(product));
    }
    @DeleteMapping(value = "/{id}/deleteProduct")
    public ResponseEntity<BaseResponse<?>> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new BaseResponse<>("SUCCESS"));
    }
    @PutMapping(value = "/{id}/buyProduct")
    public ResponseEntity<BaseResponse<?>> buyProduct(@PathVariable("id") Long id, @RequestParam("quantity") Integer quantity) {
        String result = productService.buyProduct(id, quantity);
        return ResponseEntity.ok(new BaseResponse<>(result));
    }
}
