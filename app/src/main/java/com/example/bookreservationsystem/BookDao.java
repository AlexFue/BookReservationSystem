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

    @Query("select distinct genre from books")
    List<String> getAllGenres();

    @Query("select title from books where availability = 'available' and genre = :genre")
    List<String> getAllTitlesByGenre(String genre);

    @Query("select * from books where availability = 'available'")
    List<Book> getAllAvailableBooks();

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

    @Query("update books set availability = 'notavailable' where mBookId = :book_id")
    void setAvailability(int book_id);

    @Insert
    long addBook(Book book);

    @Insert
    long[] insertBooks(Book... books);
}

