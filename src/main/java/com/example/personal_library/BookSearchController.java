/*

package com.example.personal_library;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.util.List;

public class BookSearchController {

    @FXML private TextField searchField;
    @FXML private ListView<Book> resultsList;

    private final BookAPIService apiService = new BookAPIService();
    private Book selectedBook;

    @FXML
    private void handleSearch() {
        String query = searchField.getText().trim();
        if (!query.isEmpty()) {
            try {
                List<Book> results = apiService.searchBooks(query);
                resultsList.getItems().setAll(results);
            } catch (Exception e) {
                e.printStackTrace();
                // Show error to user
            }
        }
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    // Custom cell factory to display book info with images
    public static class BookCellFactory extends ListCell<Book> {
        private final HBox content;
        private final Text title;
        private final Text author;
        private final ImageView cover;

        public BookCellFactory() {
            super();
            cover = new ImageView();
            cover.setFitHeight(80);
            cover.setFitWidth(60);
            cover.setPreserveRatio(true);

            title = new Text();
            author = new Text();
            title.setStyle("-fx-font-weight: bold;");

            VBox textBox = new VBox(title, author);
            content = new HBox(cover, textBox);
            content.setSpacing(10);
        }

        @Override
        protected void updateItem(Book book, boolean empty) {
            super.updateItem(book, empty);
            if (book != null && !empty) {
                title.setText(book.getTitle());
                author.setText(book.getAuthor() + " (" + book.getYear() + ")");

                if (!book.getImageUrl().isEmpty()) {
                    cover.setImage(new Image(book.getImageUrl()));
                } else {
                    cover.setImage(new Image(getClass().getResourceAsStream("/default_book.png")));
                }

                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
    }
}

 */