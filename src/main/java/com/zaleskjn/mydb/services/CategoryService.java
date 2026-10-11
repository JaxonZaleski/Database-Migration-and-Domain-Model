package com.zaleskjn.mydb.services;

import com.zaleskjn.mydb.entities.Category;
import com.zaleskjn.mydb.entities.Product;
import com.zaleskjn.mydb.repositories.CategoryRepository;
import com.zaleskjn.mydb.repositories.ProductRepository;
import com.zaleskjn.mydb.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final EntityManager entityManager;
    private final UserRepository userRepository;

    @Transactional
    public void showEntityState() {
        var category = Category.builder()
                .name("Electronics")
                .build();

        if(entityManager.contains(category)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }

        categoryRepository.save(category);

        if(entityManager.contains(category)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }
    }

    @Transactional
    public void showRelatedEntities() {
//        var user = userRepository.findById(2L).orElseThrow();
//        System.out.println(user.getEmail());
        var product = productRepository.findById(2L).orElseThrow();
//        System.out.println(profile.getBio());
        System.out.println(product.getCategory().getName());
    }

    public void PersistRelated() {
        //Create new category
//        var category = Category.builder()
//                .name("Sports")
//                .build();
//        var product = Product.builder()
//                .name("Baseball")
//                .description("For Baseball")
//                .price(new BigDecimal("30.00"))
//                .build();

//        Save Category
//        category.addProduct(product);
//        categoryRepository.save(category);

        //Find id then create new product
        var category = categoryRepository.findById(3).orElseThrow();
        var product = Product.builder()
                .name("Jeans")
                .description("For protection")
                .price(new BigDecimal("20.00"))
                .category(category)
                .build();

        //Save Product
        productRepository.save(product);

    }

    @Transactional
    public void deleteRelated() {
//        userRepository.deleteById(6L);
        var category = categoryRepository.findById(3).orElseThrow();
        var product = category.getProducts().getFirst();
        category.removeProduct(product);
        categoryRepository.save(category);
    }
}