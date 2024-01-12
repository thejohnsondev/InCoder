package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("assets/fxmls/mainWindow.fxml"));
//        fxmlLoader.setRoot(new AnchorPane());
//
//        Parent root = fxmlLoader.load();
//        primaryStage.setTitle("InCoder 2");
//        primaryStage.getIcons().add(new Image("com/sample/assets/img/Icon.png"));
//        primaryStage.setScene(new Scene(root, 1080, 800));
//        primaryStage.setResizable(false);
//        primaryStage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 800);
        stage.setTitle("InCoder 2");
//        stage.getIcons().add(new Image("com/sample/assets/img/Icon.png"));
        stage.setScene(scene);
        stage.setResizable(false);;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}