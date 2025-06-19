package com.example.personal_library;
import java.io.*;
import java.util.*;

public class FileManager {

    public static List<Book> readBooksFromCSV(String filename) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 5) {
                    Book book = new Book(fields[0], fields[1], fields[2],
                            Integer.parseInt(fields[3]), fields[4]);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static void writeBooksToCSV(String filename, List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Title,Author,Genre,Year,ISBN\n");
            for (Book book : books) {
                writer.write(String.format("%s,%s,%s,%d,%s\n",
                        book.getTitle(), book.getAuthor(), book.getGenre(),
                        book.getYear(), book.getIsbn()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
