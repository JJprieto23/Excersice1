package com.problema1.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Título: " + title + ", Autor: " + author + ", ISBN: " + isbn + ", Año: " + publicationYear
                + ", Prestado: " + (isBorrowed ? "Sí" : "No");
    }
}