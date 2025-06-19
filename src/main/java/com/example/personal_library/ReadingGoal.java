package com.example.personal_library;

import java.time.Year;
import java.util.Objects;

public class ReadingGoal {
    int targetBooks;
    int booksRead;
    Year goalYear;

    public int getTargetBooks() {
        return targetBooks;
    }

    public void setTargetBooks(int targetBooks) {
        this.targetBooks = targetBooks;
    }

    public int getBooksRead() {
        return booksRead;
    }

    public void setBooksRead(int booksRead) {
        this.booksRead = booksRead;
    }

    public Year getGoalYear() {
        return goalYear;
    }

    public void setGoalYear(Year goalYear) {
        this.goalYear = goalYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReadingGoal that)) return false;
        return targetBooks == that.targetBooks && booksRead == that.booksRead && Objects.equals(goalYear, that.goalYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetBooks, booksRead, goalYear);
    }

    @Override
    public String toString() {
        return "ReadingGoal{" +
                "targetBooks=" + targetBooks +
                ", booksRead=" + booksRead +
                ", goalYear=" + goalYear +
                '}';
    }

    private void updateProgress() {

    }

    private boolean isGoalMet() {

        return false;
    }

}
