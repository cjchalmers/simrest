package nl.simplexit.rest;

import lombok.Data;
//import org.springframework.data.annotation.Id;

/**
 * Created by colin on 30-12-15.
 */
@Data
public class Book {

    //@Id
    private String id;

    private String name;

    private String isbn;

    private String author;

    private int pages;

    public Book(){}

    public Book(String name, String isbn, String author, int pages){
        this.name = name;
       this.isbn = isbn;
        this.author = author;
       this.pages = pages;
    }
}
