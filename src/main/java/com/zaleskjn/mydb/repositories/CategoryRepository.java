package com.zaleskjn.mydb.repositories;

import com.zaleskjn.mydb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}