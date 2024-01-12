package com.example.demo.algorithms.classical;

import java.util.HashMap;
import java.util.Map;

public class MorseEncrypt {

    private Map<String, String> symb;
    private Map<String, String> symbEncrypt;


    public String decrypt(String text) {
        symb = new HashMap<String, String>();
        symb.put(".-", "a");
        symb.put("-...", "b");
        symb.put("-.-.", "c");
        symb.put("-..", "d");
        symb.put(".", "e");
        symb.put("..-.", "f");
        symb.put("--.", "g");
        symb.put("....", "h");
        symb.put("..", "i");
        symb.put(".---", "j");
        symb.put("-.-", "k");
        symb.put(".-..", "l");
        symb.put("--", "m");
        symb.put("-.", "n");
        symb.put("---", "o");
        symb.put(".--.", "p");
        symb.put("--.-", "q");
        symb.put(".-.", "r");
        symb.put("...", "s");
        symb.put("-", "t");
        symb.put("..-", "u");
        symb.put("...-", "v");
        symb.put(".--", "w");
        symb.put("-..-", "x");
        symb.put("-.--", "y");
        symb.put("--..", "z");

        symb.put("_", " ");
        symb.put("","");
        symb.put("\n","\n");
        symb.put("\t","\t");


        symb.put("-----", "0");
        symb.put(".----", "1");
        symb.put("..---", "2");
        symb.put("...--", "3");
        symb.put("....-", "4");
        symb.put(".....", "5");
        symb.put("-....", "6");
        symb.put("--...", "7");
        symb.put("---..", "8");
        symb.put("----.", "9");

        String[] signal = text.split("\\s+");
        String result = "";
        for (int i = 0; i < signal.length; i++) {
            result += symb.get(signal[i]);
        }
        return result;

    }


    public String encrypt(String text) {
        symbEncrypt = new HashMap<>();
        symbEncrypt.put("a",".-");     symbEncrypt.put("A",".-");
        symbEncrypt.put("b","-...");   symbEncrypt.put("B","-...");
        symbEncrypt.put("c","-.-.");   symbEncrypt.put("C","-.-.");
        symbEncrypt.put("d","-..");    symbEncrypt.put("D","-..");
        symbEncrypt.put("e",".");      symbEncrypt.put("E",".");
        symbEncrypt.put("f","..-.");   symbEncrypt.put("F","..-.");
        symbEncrypt.put("g","--.");    symbEncrypt.put("G","--.");
        symbEncrypt.put("h","....");   symbEncrypt.put("H","....");
        symbEncrypt.put("i","..");     symbEncrypt.put("I","..");
        symbEncrypt.put("j",".---");   symbEncrypt.put("J",".---");
        symbEncrypt.put("k","-.-");    symbEncrypt.put("K","-.-");
        symbEncrypt.put("l",".-..");   symbEncrypt.put("L",".-..");
        symbEncrypt.put("m","--");     symbEncrypt.put("M","--");
        symbEncrypt.put("n","-.");     symbEncrypt.put("N","-.");
        symbEncrypt.put("o","---");    symbEncrypt.put("O","---");
        symbEncrypt.put("p",".--.");   symbEncrypt.put("P",".--.");
        symbEncrypt.put("q","--.-");   symbEncrypt.put("Q","--.-");
        symbEncrypt.put("r",".-.");    symbEncrypt.put("R",".-.");
        symbEncrypt.put("s","...");    symbEncrypt.put("S","...");
        symbEncrypt.put("t","-");      symbEncrypt.put("T","-");
        symbEncrypt.put("u","..-");    symbEncrypt.put("U","..-");
        symbEncrypt.put("v","...-");   symbEncrypt.put("V","...-");
        symbEncrypt.put("w",".--");    symbEncrypt.put("W",".--");
        symbEncrypt.put("x","-..-");   symbEncrypt.put("X","-..-");
        symbEncrypt.put("y","-.--");   symbEncrypt.put("Y","-.--");
        symbEncrypt.put("z","--..");   symbEncrypt.put("Z","--..");

        symbEncrypt.put("0","-----");  symbEncrypt.put(" ","_");
        symbEncrypt.put("1",".----");  symbEncrypt.put("","");
        symbEncrypt.put("2","..---");  symbEncrypt.put("\n","\n");
        symbEncrypt.put("3","...--");  symbEncrypt.put("\t","\t");
        symbEncrypt.put("4","....-");
        symbEncrypt.put("5",".....");
        symbEncrypt.put("6","-....");
        symbEncrypt.put("7","--...");
        symbEncrypt.put("8","---..");
        symbEncrypt.put("9","----.");



        String[] signal = text.split("");
        String result = "";
        for (int i = 0; i < signal.length; i++) {
            result += symbEncrypt.get(signal[i]) + " ";
        }
        return result;
    }
    // TODO: 13.03.2020 add a ucrainian alphabet for encrypt
}