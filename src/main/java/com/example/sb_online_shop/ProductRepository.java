package com.example.sb_online_shop;

import org.springframework.data.repository.CrudRepository;
import com.example.sb_online_shop.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
