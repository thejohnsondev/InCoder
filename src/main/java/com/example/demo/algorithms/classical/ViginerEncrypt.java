package com.example.demo.algorithms.classical;

import java.util.Random;

public class ViginerEncrypt {

    public String encrypt(String key, String text){
        String alph = "abcdefghijklmnopqrstuvwxyz";

        String keyFinal = "";
        int N = 26;
        int i = 0;
        while (keyFinal.length() != text.length()){
            for(int q = 0;q<key.length();q++){
                keyFinal+=key.charAt(q);
                if(keyFinal.length() == text.length()){
                    break;
                }
            }
            i++;
        }

        int[] textIndex = new int[text.length()];
        int[] keyIndex = new int[keyFinal.length()];
        for (int j = 0; j < text.length(); j++) {
            textIndex[j] = alph.indexOf(text.charAt(j));
            keyIndex[j] = alph.indexOf(keyFinal.charAt(j));
        }

        int[] encryptedIndex = new int[text.length()];
        String encryptedText = "";

        for (int k = 0; k < text.length(); k++) {
            if (text.charAt(k) == ' '){
                encryptedText += ' ';
            }else {
                encryptedIndex[k] = (textIndex[k] + keyIndex[k]) % N;
                if (encryptedIndex[k] > N)     encryptedIndex[k] -= N;
                encryptedText += alph.charAt(encryptedIndex[k]);
            }
        }
        return encryptedText;
    }

    public String decrypt(String key,String text) {
        String alph2 = "abcdefghijklmnopqrstuvwxyz";

        String keyFinal = "";
        int N = 26;
        int i = 0;

        while (keyFinal.length() != text.length()){
            for (int q = 0; q < key.length(); q++){
                keyFinal += key.charAt(q);
                if(keyFinal.length() == text.length()){
                    break;
                }
            }
            i++;
        }

        int[] textIndex = new int[text.length()];
        int[] keyIndex = new int[keyFinal.length()];
        for (int j = 0;j < text.length(); j++){
            textIndex[j] = alph2.indexOf(text.charAt(j));
            keyIndex[j] = alph2.indexOf(keyFinal.charAt(j));
        }

        int[] decryptedIndex = new int[text.length()];
        String decryptedText = "";

        for (int k = 0; k < text.length(); k++){
            if(text.charAt(k) == ' '){
                decryptedText += ' ';
            }else {
                decryptedIndex[k] = (textIndex[k] - keyIndex[k]) % N;
                if (decryptedIndex[k] < 0) decryptedIndex[k] += N;
                decryptedText += alph2.charAt(decryptedIndex[k]);
            }
        }
        return decryptedText;
    }

    public String keyGen(){
        String key = "";
        String alph = "abcdefghijklmnopqrstuvwxyz";

        int min = 2;
        int max = 5;
        int dif = max - min;
        Random random = new Random();

        int i = random.nextInt(dif+1);
        i += min;

        for (int j = 0; j < i; j++) {
            key += alph.charAt(random.nextInt(alph.length()));
        }

        return key;
    }

    // TODO: 13.03.2020 add a ucrainian alphabet for encrypt

}
