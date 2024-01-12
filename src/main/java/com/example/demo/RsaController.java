package com.example.demo;

import com.example.demo.algorithms.modern.RSAEncrypt;
import com.example.demo.utilities.BuferOperation;
import com.example.demo.utilities.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Polygon;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;

public class RsaController {
    //fields --------------------

    RSAEncrypt rsaEncrypt  = new RSAEncrypt();

    Key publicKey;
    Key privateKey;

    ToggleGroup radioGroup1;
    ToggleGroup radioGroup2;

    boolean encryptMode = true;
    boolean isHiden = false;

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
    private Button openFileBtn;
    @FXML
    private Button saveFileBtn;
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

        triangleDecrypt.setVisible(false);

        openFileBtn.setDisable(true);
        saveFileBtn.setDisable(true);


    }

    public void operationStart(ActionEvent actionEvent) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {

        String inputText = inputTextArea.getText();

        if(encryptMode){
            outputTextArea.setText(rsaEncrypt.encrypt(inputText));
        }
        else if(!encryptMode){
            outputTextArea.setText(rsaEncrypt.decrypt(inputText));
        }

    }

    public void hideKeyBtnAction(ActionEvent actionEvent) {

        if(!isHiden){
            keyTextField.setText("******************** . . . ");
            isHiden = true;
        }else if(isHiden){
            keyTextField.setText(publicKey.toString().substring(41,659));
            isHiden = false;
        }

    }

    public void genKeyBtn(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = pairgen.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();

        rsaEncrypt.setPrivateKey(privateKey);
        rsaEncrypt.setPublicKey(publicKey);

        keyTextField.setText(publicKey.toString().substring(41,659));
        System.out.println(publicKey.toString());
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
