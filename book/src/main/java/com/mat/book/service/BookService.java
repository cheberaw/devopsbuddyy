package com.mat.book.service;

import com.mat.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    public String addBook(Book book) {
        books.add(book);
        return "success";
    }
    public String addListBook(List<Book> books) {
        books.addAll(books);
        System.out.println(books);
        return "success";
    }
    public Book getBook(String isbn) {

        Optional<Book> book = books.stream().filter(b -> b.getIsbn().equalsIgnoreCase(isbn)).findFirst();
        if(book.isEmpty()) {
            return null;
        } else {
            return book.get();
        }
    }
    public List<Book> getListOfBook() {
        return books;
    }

    public String deleteBook(String isbn) {
        books.removeIf(b -> b.getIsbn().equalsIgnoreCase(isbn));
        return "success";
    }
}
