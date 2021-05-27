package com.example.bookreservationsystem;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//creating books table for database
@Entity(tableName = "books")
public class Book {
    // adding columns to table
    @PrimaryKey(autoGenerate = true)
    private int mBookId;

    @ColumnInfo(name="title")
    private String mTitle;

    @ColumnInfo(name="author")
    private String mAuthor;

    @ColumnInfo(name="genre")
    private String mGenre;

    @ColumnInfo(name="availability")
    private String mAvailability;

    public Book(String title, String author, String genre, String availability){ // constructor to create an object of the table to add
        mTitle = title;
        mAuthor = author;
        mGenre = genre;
        mAvailability = availability;
    }
    // functions to get / set variables
    public String getAvailability() {
        return mAvailability;
    }

    public void setAvailability(String mAvailability) {
        this.mAvailability = mAvailability;
    }

    public int getBookId() {
        return mBookId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setBookId(int mBookId) {
        this.mBookId = mBookId;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public void setGenre(String mGenre) {
        this.mGenre = mGenre;
    }
}

