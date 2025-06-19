package com.example.personal_library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

//main class
public class LibraryApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Loads the fxml file - stores the GUI information
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        //The scene - represents the visual contents of the stage
        Scene scene = new Scene(root);

        Image icon = new Image("BooksIcon.jpeg"); //to add the image from the file added into resources
        stage.getIcons().add(icon); //add the image 'icon' to the stage (displays a book image)

        stage.setScene(scene);
        stage.setTitle("Personal Library"); //add a title for the stage
        stage.show();//shows the stage - opens the window of the GUI and all contents
    }


}