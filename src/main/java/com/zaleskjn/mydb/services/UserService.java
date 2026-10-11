package com.zaleskjn.mydb.services;

import com.zaleskjn.mydb.entities.Addresses;
import com.zaleskjn.mydb.entities.Profiles;
import com.zaleskjn.mydb.entities.User;
import com.zaleskjn.mydb.repositories.ProfilesRepository;
import com.zaleskjn.mydb.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfilesRepository profilesRepository;

    @Transactional
    public void showEntityState() {
        var user = User.builder()
                .name("John Doe")
                .email("jdoe@example.com")
                .password("password")
                .build();

        if(entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }

        userRepository.save(user);

        if(entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }
    }

    @Transactional
    public void showRelatedEntities() {
//        var user = userRepository.findById(2L).orElseThrow();
//        System.out.println(user.getEmail());
        var profile = profilesRepository.findById(2L).orElseThrow();
//        System.out.println(profile.getBio());
        System.out.println(profile.getUser().getEmail());
    }

    public void PersistRelated() {
        var user = User.builder()
                .name("Mike Smith")
                .email("mike@example.com")
                .password("password")
                .build();

        var address = Addresses.builder()
                .street("Vine Street")
                .city("Cincinnati")
                .state("OH")
                .zip("45202")
                .build();

        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
//        userRepository.deleteById(6L);
        var user = userRepository.findById(7L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }
}