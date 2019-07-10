package com.ch5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Ch5Application {

    @Value("${book.author}")
    private String bootAuthor;

    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    String index() {
        return "Hello Spring Boot， \n bookName: " + bookName + " \n bookAuthor: " + bootAuthor ;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch5Application.class, args);
    }




}
