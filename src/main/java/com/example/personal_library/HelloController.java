package com.example.personal_library;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

public class HelloController {

    @FXML private TableView<Book> booksTable;

    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> genreColumn;
    @FXML private TableColumn<Book, String> isbnColumn;
    @FXML private TableColumn<Book, Integer> yearColumn;
    @FXML private TableColumn<Book, String> readColumn;
    @FXML private TableColumn<Book, LocalDate> startDateColumn;
    @FXML private TableColumn<Book, LocalDate> endDateColumn;

    private final LinkedList<Book> bookList = new LinkedList<>();

    @FXML
    public void initialize() {
        // Bind columns to Book fields using getter names
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        readColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().isRead() ? "Read" : "Not Read")
        ); //This changes the boolean values of true/false to a more readable format of read/not read
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        // Sample data - to test functionality
        Book b1 = new Book("1984", "George Orwell", "Dystopian", 1949, "1234567890");
        b1.markAsRead(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 10));

        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, "0987654321");

        bookList.add(b1);
        bookList.add(b2);

        booksTable.getItems().addAll(bookList);
    }

    @FXML
    private void openAddBookDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-book.fxml"));
            Parent root = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Book");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(booksTable.getScene().getWindow());
            dialogStage.setScene(new Scene(root));

            AddBook controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            if (controller.isBookAdded()) {
                Book newBook = controller.getNewBook();
                booksTable.getItems().add(newBook);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRemoveBook() {
        Book selectedBook = booksTable.getSelectionModel().getSelectedItem();

        if (selectedBook != null) {
            booksTable.getItems().remove(selectedBook);
            bookList.remove(selectedBook); // Optional, if you want to keep bookList in sync
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table to remove.");
            alert.showAndWait();
        }
    }


}
