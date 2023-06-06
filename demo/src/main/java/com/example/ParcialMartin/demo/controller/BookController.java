package com.example.ParcialMartin.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ParcialMartin.demo.model.Book;
import com.example.ParcialMartin.demo.repository.BookRepository;

@RestController
@RequestMapping("/crudB")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Book findBook(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    @GetMapping("/read")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Book> Books(){
        return (java.util.List<Book>) bookRepository.findAll();
    }

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public Book create(@RequestBody Book newBook){
        return bookRepository.save(newBook);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public void update(@RequestBody Book newBook){
        bookRepository.save(newBook);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Long id){
        bookRepository.deleteById(id);
    }
	
}