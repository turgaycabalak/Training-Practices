package com.bookstore.bookseller.business;

import com.bookstore.bookseller.dataAccess.BookRepository;
import com.bookstore.bookseller.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public Book saveBook(Book book){
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
