package com.zaleskjn.mydb;

import com.zaleskjn.mydb.entities.User;
import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.apache.catalina.User.*;

@SpringBootApplication
public class MyDbApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MyDbApplication.class, args);

        var user = User.builder()
                       .id(1L)
                       .name("John")
                       .email("john@example.com")
                       .password("Password")
                       .build();
    }

}
