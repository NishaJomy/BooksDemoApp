package org.launchcode.booksdemo.controllers;

import org.launchcode.booksdemo.model.Book;


import org.launchcode.booksdemo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @GetMapping("")

    public String displayBooks(Model model){
        Iterable<Book> books;
        books=bookRepository.findAll();
        model.addAttribute("books",books);
        return "index";
    }

    @GetMapping("add")

    public String displayAddForm(Model model){
        model.addAttribute("book",new Book());
        return "add";
    }
    @PostMapping("add")
    public String renderAddForm(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:";
    }

    @GetMapping("view/{id}")
    public String viewBook(Model model,@PathVariable Integer id){
        Optional<Book> result=bookRepository.findById(id);
        if(result.isPresent()){
            Book book =result.get();

        model.addAttribute("book",book);}
        return "view";
    }
    @GetMapping("delete")
    public String displaydeleteForm(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "delete";
    }




}
