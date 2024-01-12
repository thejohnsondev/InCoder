package com.example.demo.utilities.threads;

import com.example.demo.utilities.MorsePlay;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PlayThread extends Thread{

    private TextArea textArea;
    private Button playBtn;


    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public void setPlayBtn(Button playBtn) {
        this.playBtn = playBtn;
    }


    @Override
    public void run() {

        try {
            MorsePlay.play(textArea.getText());
            playBtn.setDisable(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(Thread.currentThread().isInterrupted()){
            this.interrupt();
        }



    }


}
