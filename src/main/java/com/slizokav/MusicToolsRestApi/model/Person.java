package com.slizokav.MusicToolsRestApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "username may not be empty")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "password may not be empty")
    private String password;

    @Column(name = "role")
    @NotEmpty(message = "role may not be empty")
    private String role;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
