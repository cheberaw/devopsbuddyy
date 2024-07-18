package com.mat.book.controller;

import com.mat.book.model.Book;
import com.mat.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add/book")
    public String addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    @PostMapping("/add/listbook")
    public String addListBook(@RequestBody List<Book> book) {
        return bookService.addListBook(book);
    }
    @GetMapping("/isbnbook/{isbn}")
    public Book getBook(@PathVariable String isbn) {
       return bookService.getBook(isbn);
    }
    @GetMapping("/book")
    public Book getBookByIsbn(@RequestParam String isbn) {
        return bookService.getBook(isbn);
    }
    @GetMapping("/getbook")
    public String getBooks() {
        return "book found!!! success";
    }
    @GetMapping("/listbook")
    public List<Book> getListOfBook() {
        return bookService.getListOfBook();
    }
    @DeleteMapping("deletebook")
    public String deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }
}
