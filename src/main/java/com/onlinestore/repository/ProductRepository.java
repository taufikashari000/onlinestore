package com.onlinestore.repository;

import com.onlinestore.dto.ProductDto;
import com.onlinestore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT new com.onlinestore.dto.ProductDto(p.id, p.name, p.price, p.quantity) FROM Product p",
    countQuery = "SELECT COUNT(*) FROM Product")
    List<ProductDto> getAllProduct();
    @Query(value = "SELECT quantity FROM products WHERE id=:id", nativeQuery = true)
    Integer productQuantity(Long id);
}
