package com.UST.BookService.controller;

import com.UST.BookService.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    Environment environment;

    @GetMapping("/data")
    public String getBookData(){
        return "data of BOOK-SERVICE , running on port :"
                +environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return new Book(id,"Read first java", 500.70 );
    }
    @GetMapping("/all")
    public List<Book>getAll(){
        return List.of(
                new Book(501,"Head first java",419.75),
                new Book(502,"Spring in Action",340.75),
                new Book(503,"Hibernate in action",355.75)
        );
    }
    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData(){
        return new ResponseEntity<String>(
                "Hello from BookRestController",
                HttpStatus.OK);
    }
}
