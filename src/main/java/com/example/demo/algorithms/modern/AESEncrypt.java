package com.example.demo.algorithms.modern;

import com.example.demo.utilities.Constants;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;


public class AESEncrypt {


    public String encrypt(String key, String text){
        try {
            if(!isKeyLengthValid(key)){
                throw new Exception("Secret key's length must be 128, 192 or 256 bits");
            }

            IvParameterSpec ivParameterSpec = new IvParameterSpec(Constants.INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"),"AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,ivParameterSpec);


//            return new String(HexBin.encode(cipher.doFinal(text.getBytes("UTF-8"))));
        } catch (Throwable cause) {
            System.out.println(cause.getMessage());
        }
        return null;

    }

    public String decrypt(String key, String cipherText){
        try {
            if(!isKeyLengthValid(key)){
                throw new Exception("Secret key's length must be 128 bits");
            }

            IvParameterSpec ivParameterSpec = new IvParameterSpec(Constants.INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"),"AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec,ivParameterSpec);

            return new String();
        } catch (Throwable cause) {
            System.out.println(cause.getMessage());
        }
        return null;
    }

    public boolean isKeyLengthValid(String key){
        return key.length() == 16;
    }

    public String keyGen() {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        String alphFull = alph + alph.toUpperCase() + "1234567890";
        String key = "";

        Random random = new Random();

        for (int i = 0; i < 16;i++){
            key += alphFull.charAt(random.nextInt(alphFull.length()));
        }
        return key;
    }


}
