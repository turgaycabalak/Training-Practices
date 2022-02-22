package com.bookstore.bookseller.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    @Column(nullable = false)
    private Double price;

    @Column(name = "purchase_time",nullable = false)
    private LocalDateTime purchaseTime;

    public Purchase(User user, Book book, Double price,LocalDateTime purchaseTime) {
        this.user = user;
        this.book = book;
        this.price = price;
        this.purchaseTime = purchaseTime;
    }

    public Purchase() {

    }
}
