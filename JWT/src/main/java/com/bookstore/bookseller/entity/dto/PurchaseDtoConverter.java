package com.bookstore.bookseller.entity.dto;

import com.bookstore.bookseller.business.BookService;
import com.bookstore.bookseller.business.UserService;
import com.bookstore.bookseller.entity.Book;
import com.bookstore.bookseller.entity.Purchase;
import com.bookstore.bookseller.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PurchaseDtoConverter {

    private final UserService userService;
    private final BookService bookService;


    public Purchase PurchaseRequestToPurchase(PurchaseRequest purchaseRequest){
        User user = userService.findUserById(purchaseRequest.getUserId()).get();
        Book book = bookService.findBookById(purchaseRequest.getBookId()).get();
        return new Purchase(user,book, purchaseRequest.getPrice(), LocalDateTime.now());
    }

}
