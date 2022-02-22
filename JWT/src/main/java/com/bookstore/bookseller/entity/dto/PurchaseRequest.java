package com.bookstore.bookseller.entity.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class PurchaseRequest {

    private Long userId;
    private Long bookId;
    private Double price;

}
