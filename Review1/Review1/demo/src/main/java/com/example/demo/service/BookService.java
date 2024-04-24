package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    public Book getBookById(int id){
         return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBookByAuthor(String authorName){
        return bookRepository.findByAuthorName(authorName);
    }

    public List<Book> getBookByCategory(String categoryName){
        return bookRepository.findByCategory(categoryName);
    }


    public List<Book> getBookByTitle(String title){
        return bookRepository.findByBookTitleIgnoreCaseContaining(title);
    }

    public List<Book> getBookByPrice(double price){
        return bookRepository.findByPriceLessThan(price);
    }

    public void postBook(Book b){
        bookRepository.save(b);
    }

    public void deleteBookById(int id){
          bookRepository.deleteById(id);
    }
}
