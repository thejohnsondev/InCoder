package com.example.demo.algorithms.modern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;




public class RSAEncrypt {


    Key publicKey;
    Key privateKey;

    private String encryptedText = "";
    private byte[] bytes;

    public void setPrivateKey(Key privateKey) {
        this.privateKey = privateKey;
    }

    public void setPublicKey(Key publicKey) {
        this.publicKey = publicKey;
    }



    public String encrypt(String text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);

        bytes = cipher.doFinal(text.getBytes());


        for (byte b: bytes) {
            encryptedText+= b+"";
        }
        System.out.println("-----Public key-----");
        System.out.println(publicKey);
        System.out.println("-----Text-----");

        return encryptedText;
    }

    public String decrypt(String encryptedText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);

        byte[] byte2 = cipher.doFinal(bytes);

        String decryptedText = "";
        for (byte b:byte2){
            decryptedText+= (char)b+"";
        }
        System.out.println("-----Private key------");
        System.out.println(privateKey);
        System.out.println("-----Text-----");

        return decryptedText;

    }





}
