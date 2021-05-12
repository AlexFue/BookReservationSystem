package com.example.bookreservationsystem;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {

    // returns number of rows in books table
    @Query("select count(*) from books")
    int count();

    @Query("select * from books")
    List<Book> getAllBooks();

    @Query("select * from books where title = :title")
    Book findBookByTitle(String title);

    @Query("select * from books where author = :author")
    Book findBookByAuthor(String author);

    @Query("select * from books where genre = :genre")
    Book findBookByGenre(String genre);

    @Query("select * from books where availability = :availability")
    Book findBookByAvailability(String availability);

    @Query("select * from books where mBookId = :bookId")
    Book findById(int bookId);

    @Insert
    long addBook(Book book);

    @Insert
    long[] insertBooks(Book... books);
}

