 package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

//    @Autowired
//    AuthorRepository authorRepository1;

    public void createBook(Book book){

//        int authorId = book.getAuthor().getId();
//        Author author = authorRepository1.findById(authorId).get();
//
//        author.getBooksWritten().add(book);
//        book.setAuthor(author);

        bookRepository2.save(book);
//        authorRepository1.save(author);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = null; //find the elements of the list by yourself

        if(genre != null && author != null){
            books = bookRepository2.findBooksByGenreAuthor(genre, author, available);
        } else if (genre != null) {
            books = bookRepository2.findBooksByGenre(genre, available);
        } else if (author != null) {
            books = bookRepository2.findBooksByAuthor(author, available);
        }else {
            books = bookRepository2.findByAvailability(available);
        }

//        if(author == null){
//            books = bookRepository2.findBooksByGenre(genre, available);
//        }else{
//            books = bookRepository2.findBooksByAuthor(author, available);
//        }

        return books;
    }
}