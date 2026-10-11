package com.zaleskjn.mydb.repositories;

import com.zaleskjn.mydb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}