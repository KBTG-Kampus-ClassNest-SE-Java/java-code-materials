package com.example.javacourse.profile;

import com.example.javacourse.wallet.Wallet;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    private String email;

    private String name;

    @OneToMany(mappedBy = "profile")
    private List<Wallet> wallets;

    // Getter, Setter, Constructors, equals, hashCode and toString
    // ...
}