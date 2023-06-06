package com.example.ParcialMartin.demo.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import com.example.ParcialMartin.demo.model.Book;

@EntityScan(basePackages = "com.example.ParcialMartin.demo.model") // Adjust the package path accordingly
@ComponentScan(basePackages = "com.example.ParcialMartin.demo")
public interface BookRepository extends CrudRepository<Book, Long>{

}