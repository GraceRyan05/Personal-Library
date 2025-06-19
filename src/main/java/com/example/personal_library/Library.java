package com.example.personal_library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books = new ArrayList<>();

    private void addBook(Book book) {
        books.add(book);
    }

    private boolean removeBook(String isbn) {
        for (Book book : books) {
            if(book.getIsbn().equalsIgnoreCase(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    private void removeABook(Book book) {
        books.remove(book);
    }

    private Book findBookByTitle(String title) {

        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> filterByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book: books) {
            if(book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    private List<Book> getReadBooks() {
        List<Book> result = new ArrayList<>();
        for(Book book : books) {
            if(book.isRead()) {
                result.add(book);
            }
        }
        return result;
    }

    private List<Book> getUnreadBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (!book.isRead()) {
                result.add(book);
            }
        }
        return result;

    }

    public List<Book> getAllBooks() {
        return books;
    }

    private void loadFromFile(String filename) {

    }

    private void saveToFile(String fileName) {

    }


}
