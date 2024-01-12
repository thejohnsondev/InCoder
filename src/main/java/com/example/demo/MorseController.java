package com.example.demo;


import com.example.demo.algorithms.classical.MorseEncrypt;
import com.example.demo.utilities.BuferOperation;
import com.example.demo.utilities.FileManager;
import com.example.demo.utilities.threads.PlayThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Polygon;

public class MorseController {

    //fields ---------------------

    MorseEncrypt morseEncrypt;
    PlayThread playThread;

    ToggleGroup radioGroup1;
    ToggleGroup radioGroup2;

    boolean encryptMode = true;

    //buttons -------------------

    @FXML
    private RadioButton inputTextRadioBtn;
    @FXML
    private RadioButton textFileRadioBtn;
    @FXML
    private RadioButton encryptRadioBtn;
    @FXML
    private RadioButton decryptRadioBtn;
    @FXML
    private Button encryptOperationBtn;
    @FXML
    private Button openFileBtn;
    @FXML
    private Button saveFileBtn;
    @FXML
    private Button playBtn;

    //text areas -------------------

    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextArea outputTextArea;

    //shapes ------------------------

    @FXML
    private Polygon triangleEncrypt;
    @FXML
    private Polygon triangleDecrypt;

    @FXML
    void initialize() {
        radioGroup1 = new ToggleGroup();
        inputTextRadioBtn.setToggleGroup(radioGroup1);
        textFileRadioBtn.setToggleGroup(radioGroup1);
        inputTextRadioBtn.setSelected(true);

        radioGroup2 = new ToggleGroup();
        encryptRadioBtn.setToggleGroup(radioGroup2);
        decryptRadioBtn.setToggleGroup(radioGroup2);
        encryptRadioBtn.setSelected(true);

        triangleDecrypt.setVisible(false);

        openFileBtn.setDisable(true);
        saveFileBtn.setDisable(true);
    }

    //           decrypt radio button

    public void decryptRadioBtnAction(ActionEvent actionEvent) {
        encryptMode = false;
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
        encryptOperationBtn.setText("Decrypt   ");
        triangleEncrypt.setVisible(false);
        triangleDecrypt.setVisible(true);


    }

    //         encrypt radio button

    public void encryptRadioBtnAction(ActionEvent actionEvent) {
        encryptMode = true;
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
        encryptOperationBtn.setText("Encrypt   ");
        triangleEncrypt.setVisible(true);
        triangleDecrypt.setVisible(false);
    }

    //      encrypt/decrypt button

    public void operationStart(ActionEvent actionEvent) {
        morseEncrypt = new MorseEncrypt();
        String inputText = inputTextArea.getText();
        if(encryptMode){
            outputTextArea.setText(morseEncrypt.encrypt(inputText));
        }

        else if(!encryptMode){
            outputTextArea.setText(morseEncrypt.decrypt(inputText));
        }
    }

    //        input text radio button

    public void inputTextRadioBtnAction(ActionEvent actionEvent) {
        openFileBtn.setDisable(true);
        saveFileBtn.setDisable(true);
    }

    //       text file radio button

    public void textFileRadioBtnAction(ActionEvent actionEvent) {
        openFileBtn.setDisable(false);
        saveFileBtn.setDisable(false);
    }

    //       copy button

    public void copyBtnAction(ActionEvent actionEvent) {
        BuferOperation.copyText(outputTextArea.getText());
    }

    //      paste button

    public void pasteBtnAction(ActionEvent actionEvent) {
        inputTextArea.setText(inputTextArea.getText() + BuferOperation.pasteText());
    }

    //       open button

    public void openBtnAction(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.openFile();
        fileManager.writeInTextArea(inputTextArea);
    }

    //       save button

    public void saveBtnAction(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.saveFile(outputTextArea);
    }

    //       clear button

    public void clearBtnAction(ActionEvent actionEvent) {
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
    }

    //        play button

    public void playBtnAction(ActionEvent actionEvent) throws InterruptedException {
        playThread = new PlayThread();
        playThread.setTextArea(outputTextArea);
        playThread.setPlayBtn(playBtn);
        playThread.start();
        playBtn.setDisable(true);
    }

    //       stop button

    public void stopBtnAction(ActionEvent actionEvent) {
        if(Thread.currentThread().getName() != "main")
            playThread.interrupt();
        playBtn.setDisable(false);
    }

    // TODO: 03.03.2020 message label in bottom
}
