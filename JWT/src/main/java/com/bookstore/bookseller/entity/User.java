package com.bookstore.bookseller.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false,length = 100)
    private String username;

    @Column(nullable = false,length = 100)
    private String password;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(name = "create_time")//,nullable = false
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING) // to store the role value as String in DB
    @Column(name = "role")//,nullable = false
    private Role role;

    @Transient
    private String token;


}
