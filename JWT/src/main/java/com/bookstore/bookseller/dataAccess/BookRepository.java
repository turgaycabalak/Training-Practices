package com.bookstore.bookseller.dataAccess;

import com.bookstore.bookseller.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {



}
