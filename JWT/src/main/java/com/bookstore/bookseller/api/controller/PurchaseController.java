package com.bookstore.bookseller.api.controller;

import com.bookstore.bookseller.business.PurchaseService;
import com.bookstore.bookseller.core.security.UserPrincipal;
import com.bookstore.bookseller.entity.Purchase;
import com.bookstore.bookseller.entity.dto.PurchaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchases")
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseRequest purchaseRequest){
        return new ResponseEntity<>(purchaseService.savePurchase(purchaseRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseService.findAllPurchasesOfUser(userPrincipal.getId()));
    }

}
