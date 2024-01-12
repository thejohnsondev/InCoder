package com.example.demo.algorithms.classical;

public class CaesarEncrypt{


    public String encrypt(int key, String text){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int length = alph.length();
        String encryptedText = "";

        for (int i = 0; i < text.length() ; i++) {
            char c = text.charAt(i);
            int index = alph.indexOf(c);
            if(index < 0){
                encryptedText += c;
            }else {
                int encryptedIndex = (length + index + key) % length;
                encryptedText += alph.charAt(encryptedIndex);
            }
        }
        return encryptedText;

    }

    public String decrypt(int key, String text){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int length = alph.length();
        String decryptedText = "";

        for (int i = 0; i < text.length() ; i++) {
            char c = text.charAt(i);
            int index = alph.indexOf(c);
            if(index < 0){
                decryptedText += c;
            }else {
                int decryptedIndex = (length + index - key) % length;
                decryptedText += alph.charAt(decryptedIndex);
            }
        }
        return decryptedText;
    }

    public int keyGen(){
        int key = (int)(Math.random() * (100)/2)/2;
        if(key == 0){
            key += (int)(Math.random() * (100)/2)/2;
        }
        if(key >= 25){
            key -= (int)(Math.random() * (100)/2)/2;
        }
        return key;
    }

    // TODO: 13.03.2020 add a ucrainian alphabet for encrypt



}
