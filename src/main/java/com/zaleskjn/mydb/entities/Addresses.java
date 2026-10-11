package com.zaleskjn.mydb.entities;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "street")
    private String street;

    @Column(nullable = false, name = "city")
    private String city;

    @Column(nullable = false, name = "state")
    private String state;

    @Column(nullable = false, name = "zip")
    private String zip;

    //@Column(nullable = false, name = "user_id")
    //private Long user_id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}