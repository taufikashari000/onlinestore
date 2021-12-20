package com.onlinestore.service.serviceimplement;

import com.onlinestore.dto.ProductDto;
import com.onlinestore.model.Product;
import com.onlinestore.payload.CreateProductRequest;
import com.onlinestore.payload.EditProductRequest;
import com.onlinestore.repository.ProductRepository;
import com.onlinestore.service.ProductService;
import com.onlinestore.util.ResourceNotFoundException;
import com.onlinestore.util.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProduct() {

        return productRepository.getAllProduct();

    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Setting.getErrorString("PRODUCT NOT FOUND")));
    }

    @Override
    public Product saveNew(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        return productRepository.save(product);
    }

    @Override
    public Product editProduct(Long id, EditProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        if(productRepository.findById(id) != null) {
            product.setId(id);
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Setting.getErrorString("PRODUCT NOT FOUND")));;
        productRepository.deleteById(id);
    }

    @Override
    public String buyProduct(Long id, Integer quantity) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Setting.getErrorString("PRODUCT NOT FOUND")));;
        Integer stock = productRepository.productQuantity(id);
        if(stock != 0 && stock != null && (stock-quantity >= 0)) {
            product.setQuantity(stock-quantity);
            productRepository.save(product);
            return "SUCCESS";
        } else {
            return "OUT OF STOCK";
        }
    }
}
