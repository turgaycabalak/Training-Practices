package com.bookstore.bookseller.api.controller;

import com.bookstore.bookseller.business.AuthenticationService;
import com.bookstore.bookseller.business.UserService;
import com.bookstore.bookseller.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;


    @PostMapping("sign-up") // localhost:8080/api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody User user){
        if(userService.findUserByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/authentication/sign-up").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveUser(user));

        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @PostMapping("sign-in") // localhost:8080/api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user),HttpStatus.OK);
    }

}
