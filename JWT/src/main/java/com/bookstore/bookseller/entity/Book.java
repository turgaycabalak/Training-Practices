package com.bookstore.bookseller.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 200)
    private String title;

    @Column(nullable = false,length = 1000)
    private String descrption;

    @Column(nullable = false,length = 100)
    private String author;

    @Column(nullable = false)
    private Double price;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;


}
