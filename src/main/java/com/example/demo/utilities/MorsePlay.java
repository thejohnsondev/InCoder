package com.example.demo.utilities;

//import midi.Note;
//import midi.Tools;

public class MorsePlay {

    static int curentInstrument = Constants.ACOUSTIC_BASS;

    public static void dot() throws InterruptedException {
//        Tools.playNote(Note.p60_5_Do,curentInstrument,130,50);//200
//        Thread.sleep(200);

    }

    public static void defis() throws InterruptedException {
//        Tools.playNote(Note.p60_5_Do,curentInstrument,130,300);//300
//        Thread.sleep(500);
    }

    public static void space() throws InterruptedException {
        Thread.sleep(300);
    }

    public static void play(String signal) throws InterruptedException {
        for (int i = 0; i < signal.length(); i++) {
            if(signal.charAt(i) == '.'){
                dot();
            }
            else if(signal.charAt(i) == ' '){
                space();
            }
            else if(signal.charAt(i) == '-'){
                defis();
            }

        }


    }

}
