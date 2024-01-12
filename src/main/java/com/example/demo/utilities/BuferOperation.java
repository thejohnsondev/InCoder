package com.example.demo.utilities;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class BuferOperation {



    public static void copyText(String text){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);
    }


    public static String pasteText(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;

        try {
            return (String) clipboard.getData(flavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clearTextArea(TextArea textArea){
        textArea.setText("");
    }
    public static void clearTextArea(TextArea textArea1, TextArea textArea2){
        textArea1.setText("");
        textArea2.setText("");
    }

    public static void clearTextArea(TextField textField){
        textField.setText("");
    }


}
