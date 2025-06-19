package com.example.personal_library;

import java.util.List;
import java.util.Objects;

public class User {
    String username;
    List<Book> userLibrary;
    ReadingGoal readingGoal;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getUserLibrary() {
        return userLibrary;
    }

    public void setUserLibrary(List<Book> userLibrary) {
        this.userLibrary = userLibrary;
    }

    public ReadingGoal getReadingGoal() {
        return readingGoal;
    }

    public void setReadingGoal(ReadingGoal readingGoal) {
        this.readingGoal = readingGoal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username) && Objects.equals(userLibrary, user.userLibrary) && Objects.equals(readingGoal, user.readingGoal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userLibrary, readingGoal);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userLibrary=" + userLibrary +
                ", readingGoal=" + readingGoal +
                '}';
    }

    private void addBookToLibrary(Book book) {

    }

    private int getProgress() {

        return 0;
    }
}
