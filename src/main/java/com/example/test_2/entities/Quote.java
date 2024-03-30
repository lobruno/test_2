package com.example.test_2.entities;

import javax.persistence.*;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.Collection;

@Entity
@Data
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @Column(name = "timeInsert")
    private String timeInsert;

    @ManyToMany
    @JoinTable(
            name = "users_quotes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "quote_id")
    )
    private Collection<User> users;
}
