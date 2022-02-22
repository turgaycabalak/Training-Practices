package com.bookstore.bookseller.api.controller;

import com.bookstore.bookseller.business.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/internal")
@AllArgsConstructor
public class InternalApiController {

    private UserService userService;

    @PutMapping("make-admin/{username}") // /api/internal/make-admin/{username}
    public ResponseEntity<?> makeAdmin(@PathVariable String username){
        userService.makeAdmin(username);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
