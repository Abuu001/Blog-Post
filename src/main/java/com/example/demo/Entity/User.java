package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users")
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min = 5)
    private String password;

    @ElementCollection // stores this element to a separate table
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    ) //The @CollectionTable annotation is used to specify the name of the table that stores all the records of the collection, and the JoinColumn that refers to the primary table.
    @Column(name = "role")
    private Set<String> role;

    public User(String username, String password, Set<String> role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
