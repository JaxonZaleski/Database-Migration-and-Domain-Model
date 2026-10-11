package com.zaleskjn.mydb;

import com.zaleskjn.mydb.entities.Addresses;
import com.zaleskjn.mydb.entities.User;
import com.zaleskjn.mydb.repositories.UserRepository;
import com.zaleskjn.mydb.services.CategoryService;
import com.zaleskjn.mydb.services.UserService;
import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.apache.catalina.User.*;

@SpringBootApplication
public class MyDbApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyDbApplication.class, args);
//        var repository = context.getBean(UserRepository.class);
        var userService = context.getBean(UserService.class);
        var categoryService = context.getBean(CategoryService.class);
//        userService.showEntityState();
//        userService.showRelatedEntities();
//        userService.PersistRelated();
//        userService.deleteRelated();

//        categoryService.showEntityState();
        categoryService.PersistRelated();
//        categoryService.deleteRelated();

//        var user = User.builder()
//                .name("John")
//                .email("john@example.com")
//                .password("Password")
//                .build();

        /*var address = Addresses.builder()
                .city("Cincinnati")
                .state("Ohio")
                .street("123 Main st")
                .zip("45202")
                .build();

        user.addAddress(address);*/



//        repository.save(user);

//        var user1 = repository.findById(2L).orElseThrow();
//        System.out.println();
//        System.out.println("Emaiil: " + user1.getEmail());

//        var users = repository.findAll();
//        System.out.println();
//        users.forEach(u -> System.out.println("Email: " + u.getEmail()));

//        repository.deleteById(1L);
    }
}
