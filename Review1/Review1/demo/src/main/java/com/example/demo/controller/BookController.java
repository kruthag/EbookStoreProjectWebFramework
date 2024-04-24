package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {
    @Autowired
    public BookService bookService;

    @PostMapping("/postt")
    public String postMethodName(@RequestBody List<Book> book) {
        for(Book b:book)
        bookService.postBook(b);
        return "saved";
    }
    
    @GetMapping("/id/{value}")
    public Book getById(@PathVariable("value") int value) {
        return bookService.getBookById(value);
    }

    @GetMapping("/name/{value}")
    public List<Book> getByName(@PathVariable("value") String value) {
        return bookService.getBookByTitle(value);
    }

    @GetMapping("/author/{value}")
    public List<Book> getByCategory(@PathVariable("value") String value) {
        return bookService.getBookByAuthor(value);
    }
    
    @GetMapping("/price/{value}")
    public List<Book> getMethodName(@PathVariable("value") double price) {
        return bookService.getBookByPrice(price);
    }
    
    @GetMapping("/category/{value}")
    public List<Book> getMethodName(@PathVariable("value") String category) {
        return bookService.getBookByCategory(category);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int  id){
        if(getById(id)!=null){
            bookService.deleteBookById(id);
            return "deleted";
        }
        return "Book not exists";
    }

    @PutMapping("/update")
    public String putMethodName(@RequestParam int id,@RequestParam String price) {
        Book book=bookService.getBookById(id);
        if(book!=null){
             book.setBookTitle(price);
             bookService.postBook(book);
             return "updated";
        }
        return "Book not exists";
    }
}
