package com.example.demo;


import com.example.demo.algorithms.classical.ViginerEncrypt;
import com.example.demo.utilities.BuferOperation;
import com.example.demo.utilities.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Polygon;

public class ViginereController {
    //fields ------------------------

    ViginerEncrypt viginerEncrypt;

    String key;

    ToggleGroup radioGroup1;
    ToggleGroup radioGroup2;

    boolean encryptMode = true;
    boolean isHiden = false;

    //buttons ------------------------

    @FXML
    private RadioButton inputTextRadioBtn;
    @FXML
    private RadioButton textFileRadioBtn;
    @FXML
    private RadioButton encryptRadioBtn;
    @FXML
    private Button openFileBtn;
    @FXML
    private Button saveFileBtn;
    @FXML
    private Button encryptOperationBtn;
    @FXML
    private RadioButton decryptRadioBtn;
    @FXML
    private Button hideKeyBtn;

    //text areas ------------------------

    @FXML
    private TextField keyTextField;
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
    void initialize(){
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

    //           decrypt radio btn

    public void decryptRadioBtnAction(ActionEvent actionEvent) {
        encryptMode = false;
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
        encryptOperationBtn.setText("Decrypt   ");
        triangleEncrypt.setVisible(false);
        triangleDecrypt.setVisible(true);

    }

    //         encrypt radio btn

    public void encryptRadioBtnAction(ActionEvent actionEvent) {
        encryptMode = true;
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
        encryptOperationBtn.setText("Encrypt   ");
        triangleEncrypt.setVisible(true);
        triangleDecrypt.setVisible(false);
    }

    //        encrypt/decrypt btn

    public void operationStart(ActionEvent actionEvent) {
        viginerEncrypt = new ViginerEncrypt();
        String theKey;
        if(isHiden){
            theKey = key;
        }else {
            theKey = keyTextField.getText();
        }
        String inputText = inputTextArea.getText();
        if(encryptMode){
            outputTextArea.setText(viginerEncrypt.encrypt(theKey,inputText));
        }
        else if(!encryptMode){
            outputTextArea.setText(viginerEncrypt.decrypt(theKey,inputText));
        }
    }

    //          open btn

    public void openBtnAction(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.openFile();
        fileManager.writeInTextArea(inputTextArea);
    }

    //          save btn

    public void saveBtnAction(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.saveFile(outputTextArea);
    }

    //          copy btn

    public void copyBtnAction(ActionEvent actionEvent) {
        BuferOperation.copyText(outputTextArea.getText());
    }

    //         paste btn

    public void pasteBtnAction(ActionEvent actionEvent) {
        inputTextArea.setText(inputTextArea.getText() + BuferOperation.pasteText());
    }

    //         clear btn

    public void clearBtnAction(ActionEvent actionEvent) {
        BuferOperation.clearTextArea(inputTextArea,outputTextArea);
    }

    //         input text radio btn

    public void inputTextRadioBtnAction(ActionEvent actionEvent) {
        openFileBtn.setDisable(true);
        saveFileBtn.setDisable(true);
    }

    //         text file radio btn

    public void textFileRadioBtnAction(ActionEvent actionEvent) {
        openFileBtn.setDisable(false);
        saveFileBtn.setDisable(false);
    }

    //        hide/show key btn

    public void hideKeyBtnAction(ActionEvent actionEvent) {
        if(!isHiden){
            key = keyTextField.getText();
            hideKeyBtn.setText("Show the key");
            keyTextField.setText("");
            for (int i = 0; i < key.length(); i++) {
                keyTextField.setText(keyTextField.getText() + "*");
            }
            isHiden = true;
        }else if(isHiden){
            hideKeyBtn.setText("Hide the key");
            keyTextField.setText(key);
            isHiden = false;
        }


    }

    public void genKeyBtn(ActionEvent actionEvent) {
        ViginerEncrypt viginerEncrypt = new ViginerEncrypt();
        key = viginerEncrypt.keyGen();
        keyTextField.setText(key);
    }
    // TODO: 13.03.2020 work with choise box for choose the alphabet
}
