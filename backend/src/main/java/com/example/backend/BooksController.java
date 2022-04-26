package com.example.backend;

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

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BooksController {
    @Autowired
    private BooksRepository BookRepository;
    
    @GetMapping("/")
    public List<Books> GetBooks(){
        return BookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Books GetBook(@PathVariable Integer id){
        return BookRepository.findById(id).orElse(null);
    }

    @GetMapping("/name/{name}") 
    public List<Books> GetWmByName(@PathVariable String name){
        return BookRepository.findByBookName(name);
    }

    @PostMapping("/add")
    public Books AddBook(@RequestBody Books Book){
        return BookRepository.save(Book);
    }

    @PutMapping("/update")
    public Books UpdateBook(@RequestBody Books Book){
        Books OldBook = BookRepository.findById(Book.getId()).orElse(null);
        OldBook.setBookName(Book.getBookName());
        OldBook.setBookAuthor(Book.getBookAuthor());
        OldBook.setBooksCount(Book.getBooksCount());
        OldBook.setBooksAvailable(Book.getBooksAvailable());
        OldBook.setBookEdition(Book.getBookEdition());
        return BookRepository.save( OldBook );
    }


    @DeleteMapping("/delete/{id}")
    public void DeleteBook(@PathVariable Integer id){
        BookRepository.deleteById(id);
    }

}
