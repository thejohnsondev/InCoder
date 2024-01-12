package com.example.demo;


import com.example.demo.algorithms.modern.AESEncrypt;
import com.example.demo.utilities.BuferOperation;
import com.example.demo.utilities.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Polygon;

import java.security.NoSuchAlgorithmException;

public class AesController {
    //fields -----------------

    AESEncrypt aesEncrypt;

    String key;

    ToggleGroup radioGroup1;
    ToggleGroup radioGroup2;
    ToggleGroup radioGroup3;

    boolean encryptMode = true;
    boolean isHiden = false;
    boolean isKeyGen = false;


    //buttons ----------------

    @FXML
    private RadioButton inputTextRadioBtn;
    @FXML
    private RadioButton textFileRadioBtn;
    @FXML
    private RadioButton encryptRadioBtn;
    @FXML
    private RadioButton decryptRadioBtn;
    @FXML
    private RadioButton inputKeyRadioBtn;
    @FXML
    private RadioButton genKeyRadioBtn;
    @FXML
    private Button openFileBtn;
    @FXML
    private Button saveFileBtn;
    @FXML
    private Button hideKeyBtn;
    @FXML
    private Button genKeyBtn;
    @FXML
    private Button encryptOperationBtn;

    //text areas ----------------

    @FXML
    private TextField keyTextField;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextArea outputTextArea;

    //shapes --------------------

    @FXML
    private Polygon triangleEncrypt;
    @FXML
    private Polygon triangleDecrypt;


    @FXML
    void initialize() throws NoSuchAlgorithmException {
        radioGroup1 = new ToggleGroup();
        inputTextRadioBtn.setToggleGroup(radioGroup1);
        textFileRadioBtn.setToggleGroup(radioGroup1);
        inputTextRadioBtn.setSelected(true);

        radioGroup2 = new ToggleGroup();
        encryptRadioBtn.setToggleGroup(radioGroup2);
        decryptRadioBtn.setToggleGroup(radioGroup2);
        encryptRadioBtn.setSelected(true);

        radioGroup3 = new ToggleGroup();
        inputKeyRadioBtn.setToggleGroup(radioGroup3);
        genKeyRadioBtn.setToggleGroup(radioGroup3);
        inputKeyRadioBtn.setSelected(true);

        triangleDecrypt.setVisible(false);

        openFileBtn.setDisable(true);
        saveFileBtn.setDisable(true);
        genKeyBtn.setDisable(true);


    }

    public void operationStart(ActionEvent actionEvent) {
        aesEncrypt = new AESEncrypt();

        if(keyTextField.getText().length() != 16){
            keyTextField.setStyle("-fx-background-color: #24282E; " +
                    "-fx-border-width: 2; " +
                    "-fx-border-color: #da6161; "+
                    "font-family: Berlin Sans FB; " +
                    "-fx-font-size: 25px; " +
                    "-fx-line-height: 27px; " +
                    "-fx-text-fill: #7A91B1;");
        }else{
            keyTextField.setStyle("-fx-background-color: #24282E;" +
                    "    -fx-border-width: 2;" +
                    "    -fx-font-family: \"Berlin Sans FB\";" +
                    "    -fx-font-size: 25px;" +
                    "    -fx-line-height: 27px;" +
                    "    -fx-text-fill: #7A91B1;");
        }

        String theKey;
        if(isHiden){
            theKey = key;
        }else {
            theKey = keyTextField.getText();
        }

        String inputText = inputTextArea.getText();
        if(encryptMode){
            outputTextArea.setText(aesEncrypt.encrypt(theKey,inputText));
        }
        else if(!encryptMode){
            outputTextArea.setText(aesEncrypt.decrypt(theKey,inputText));
        }

    }

    public void hideKeyBtnAction(ActionEvent actionEvent) {
        if(!isHiden){
            key = keyTextField.getText();
            hideKeyBtn.setText("Show key");
            keyTextField.setText("");
            for (int i = 0; i < key.length(); i++) {
                keyTextField.setText(keyTextField.getText() + "*");
            }
            isHiden = true;
        }else if(isHiden){
            hideKeyBtn.setText("Hide key");
            keyTextField.setText(key);
            isHiden = false;
        }
    }

    public void genKeyBtn(ActionEvent actionEvent){
        AESEncrypt aesKey = new AESEncrypt();
        key = aesKey.keyGen();
        keyTextField.setText(key);

    }

    public void genKeyRadioBtnAction(ActionEvent actionEvent) {
        isKeyGen = true;
        genKeyBtn.setDisable(false);
    }

    public void inputKeyRadioBtnAction(ActionEvent actionEvent) {
        isKeyGen = false;
        genKeyBtn.setDisable(true);
    }

    public void openBtnAction(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.openFile();
        fileManager.writeInTextArea(inputTextArea);
    }

    public void saveBtnAction(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.saveFile(outputTextArea);
    }

    public void copyBtnAction(ActionEvent actionEvent) {
        BuferOperation.copyText(outputTextArea.getText());
    }

    public void pasteBtnAction(ActionEvent actionEvent) {
        inputTextArea.setText(inputTextArea.getText() + BuferOperation.pasteText());
    }

    public void clearBtnAction(ActionEvent actionEvent) {
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
    }


    public void decryptRadioBtnAction(ActionEvent actionEvent) {
        encryptMode = false;
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
        encryptOperationBtn.setText("Decrypt   ");
        triangleEncrypt.setVisible(false);
        triangleDecrypt.setVisible(true);
    }

    public void encryptRadioBtnAction(ActionEvent actionEvent) {
        encryptMode = true;
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
        encryptOperationBtn.setText("Encrypt   ");
        triangleEncrypt.setVisible(true);
        triangleDecrypt.setVisible(false);
    }

    public void textFileRadioBtnAction(ActionEvent actionEvent) {
        openFileBtn.setDisable(false);
        saveFileBtn.setDisable(false);
    }

    public void inputTextRadioBtnAction(ActionEvent actionEvent) {
        openFileBtn.setDisable(true);
        saveFileBtn.setDisable(true);
    }
}
