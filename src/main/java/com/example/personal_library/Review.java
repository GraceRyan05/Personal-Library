package com.example.personal_library;

import java.time.LocalDate;
import java.util.Objects;

public class Review {
    User reviewerName;
    String content;
    double rating;
    LocalDate date;

    public Review(User reviewerName, String content, double rating, LocalDate date) {
        this.reviewerName = reviewerName;
        this.content = content;
        this.rating = rating;
        this.date = LocalDate.now();
    }




    public User getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(User reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;
        return Double.compare(rating, review.rating) == 0 && Objects.equals(content, review.content) && Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, rating, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewerName='" + reviewerName + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}
