package com.example.demo.utilities;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;

public class FileManager {

    private File textFile;

    public void openFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(Constants.INITIAL_DIRECTORY));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text files","*.txt"));
        textFile = fileChooser.showOpenDialog(null);
    }

    public void saveFile(TextArea textArea){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(Constants.INITIAL_DIRECTORY));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text files","*txt"));
        textFile = fileChooser.showSaveDialog(null);

        if(textFile != null){
            writeInFile(textArea);
        }

    }

    public void writeInTextArea(TextArea textArea){
        try {

            BufferedReader buffer = new BufferedReader(new FileReader(textFile));
            String textFromFile = buffer.readLine();
            buffer.close();
            textArea.setText(textFromFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInFile(TextArea textArea){

        try {
            PrintWriter printWriter;
            printWriter = new PrintWriter(textFile);
            printWriter.print(textArea.getText());
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
