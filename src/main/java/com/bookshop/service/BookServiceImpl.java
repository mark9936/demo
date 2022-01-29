package com.bookshop.service;

import com.bookshop.model.Book;
import com.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBook(String bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
