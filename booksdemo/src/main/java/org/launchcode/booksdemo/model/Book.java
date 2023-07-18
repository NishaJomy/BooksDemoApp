package org.launchcode.booksdemo.model;

import org.launchcode.booksdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String bookName;
    private String bookTitle;
    public Book(){}

    public Book(int id, String bookName, String bookTitle) {
        this.id = id;
        this.bookName = bookName;
        this.bookTitle = bookTitle;
    }


    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
