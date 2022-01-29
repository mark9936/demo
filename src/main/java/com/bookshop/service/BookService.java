package com.bookshop.service;

import com.bookshop.model.Book;

import java.util.List;

public interface BookService {
    public Book getBook(String bookId);
    public List<Book> getBooks();
}
