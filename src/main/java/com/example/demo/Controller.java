package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    Parent root;
    CaesarController caesarController;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    //Panes --------------------------
    @FXML
    private Pane mainPane;
    //Labels ------------------------


    //Buttons --------------------------
    @FXML
    private Button morseMenuButton;
    @FXML
    private Button caesarMenuButton;
    @FXML
    private Button viginereMenuButton;
    @FXML
    private Button vermanMenuButton;
    @FXML
    private Button aesMenuButton;
    @FXML
    private Button rsaMenuButton;
    @FXML
    private Button numeralMenuButton;


    @FXML
    void initialize() throws IOException {

        caesarController = new CaesarController();

        root = FXMLLoader.load(getClass().getResource("morseWindow.fxml"));
        mainPane.getChildren().add(root);

        // TODO: 08.03.2020 Change this when you create a start fxml panel
    }

    public void morseAction(ActionEvent actionEvent) throws IOException {
        setFxml("morseWindow.fxml");
    }

    public void viginereAction(ActionEvent actionEvent) throws IOException {
        setFxml("viginereWindow.fxml");
    }

    public void caesarAction(ActionEvent actionEvent) throws IOException {
        setFxml("caesarWindow.fxml");
    }

    public void aesAction(ActionEvent actionEvent) throws IOException {
        setFxml("aesWindow.fxml");
    }

    public void rsaAction(ActionEvent actionEvent) throws IOException {
        setFxml("rsaWindow.fxml");
    }

    public void numeralAction(ActionEvent actionEvent) throws IOException {
        setFxml("numTrans.fxml");
    }

    private void setFxml(String url) throws IOException {
        mainPane.getChildren().remove(root);
        root = FXMLLoader.load(getClass().getResource(url));
        mainPane.getChildren().add(root);
    }








}
