/*

package com.example.personal_library;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class BookAPIService {
    private static final String API_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Book> searchBooks(String query) throws Exception {
        String encodedQuery = query.replace(" ", "+");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + encodedQuery + "&maxResults=40"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return parseResponse(response.body());
    }

    private List<Book> parseResponse(String json) throws Exception {
        List<Book> books = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(json);
        JsonNode items = rootNode.path("items");

        for (JsonNode item : items) {
            JsonNode volumeInfo = item.path("volumeInfo");
            String title = volumeInfo.path("title").asText();
            String author = volumeInfo.path("authors").isArray() ?
                    volumeInfo.path("authors").get(0).asText() : "Unknown Author";
            String isbn = getISBN(volumeInfo.path("industryIdentifiers"));
            int year = volumeInfo.path("publishedDate").asText().length() >= 4 ?
                    Integer.parseInt(volumeInfo.path("publishedDate").asText().substring(0, 4)) : 0;
            String genre = volumeInfo.path("categories").isArray() ?
                    volumeInfo.path("categories").get(0).asText() : "General";

            String imageUrl = volumeInfo.path("imageLinks").path("thumbnail").asText();

            Book book = new Book(title, author, genre, year, isbn);
            book.setImageUrl(imageUrl); // We'll add this to Book class
            books.add(book);
        }
        return books;
    }

    private String getISBN(JsonNode identifiers) {
        if (identifiers.isArray()) {
            for (JsonNode id : identifiers) {
                String type = id.path("type").asText();
                if (type.equals("ISBN_13") || type.equals("ISBN_10")) {
                    return id.path("identifier").asText();
                }
            }
        }
        return "";
    }
}

 */