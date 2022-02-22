package com.bookstore.bookseller.business;

import com.bookstore.bookseller.dataAccess.UserRepository;
import com.bookstore.bookseller.entity.Role;
import com.bookstore.bookseller.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
//                .orElseThrow(
//                        () -> new UsernameNotFoundException("Username not found: "+username));
    }

    @Transactional
    public void makeAdmin(String username){
        userRepository.updateUserRole(username, Role.ADMIN);
    }

    public Optional<User> findUserById(Long userId){
        return userRepository.findById(userId);
    }

}
