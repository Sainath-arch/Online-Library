package com.example.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BOOk_DETAILS")
@Entity

public class Books {
    @Id
    @GeneratedValue
    private int Id;
    
    @Column(name="Bookname") private String bookName;

    @Column(name="Author") private String BookAuthor;

    @Column(name="bookCount") private int booksCount;

    @Column(name="bookAvailable") private int BooksAvailable;

    @Column(name="bookEdition") private String BookEdition;

}
