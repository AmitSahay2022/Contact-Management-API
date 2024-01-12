package com.sahay.soft.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name = "user-id"),
               inverseJoinColumns = @JoinColumn(name = "role-id")
    )
    private Set<Role> roles=new HashSet<>();
    public User(String name, String password) {
        this.userName = name;
        this.password = password;
    }
    public User(){}
}
