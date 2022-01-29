package com.bookshop.controller;

import com.bookshop.model.Book;
import com.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getbook/{bookId}")
    public Book getBook(@PathVariable String bookId) {
        System.out.printf("*************getbook");
        return bookService.getBook(bookId);
    }

    @GetMapping("/getbooks")
    public List<Book> getBook() {
        System.out.printf("*************getbooks");
        return bookService.getBooks();
    }

}