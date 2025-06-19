package com.example.personal_library;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddBook {

    @FXML private TextField titleInput;
    @FXML private TextField authorInput;
    @FXML private TextField genreInput;
    @FXML private TextField isbnInput;
    @FXML private TextField yearInput;
    @FXML private CheckBox readInput;
    @FXML private DatePicker startDateInput;
    @FXML private DatePicker endDateInput;

    private Stage dialogStage;
    private Book newBook;
    private boolean bookAdded = false;

    public void setDialogStage(Stage stage) {
        this.dialogStage = stage;
    }

    public boolean isBookAdded() {
        return bookAdded;
    }

    public Book getNewBook() {
        return newBook;
    }

    @FXML
    private void handleAddBook() {
        try {
            String title = titleInput.getText();
            String author = authorInput.getText();
            String genre = genreInput.getText();
            String isbn = isbnInput.getText();
            int year = Integer.parseInt(yearInput.getText());

            newBook = new Book(title, author, genre, year, isbn);

            if (readInput.isSelected()) {
                LocalDate start = startDateInput.getValue();
                LocalDate end = endDateInput.getValue();
                newBook.markAsRead(start, end);
            }

            bookAdded = true;
            dialogStage.close();

        } catch (NumberFormatException e) {
            // Show alert for invalid year
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Year must be a number");
            alert.showAndWait();
        }
    }
}
