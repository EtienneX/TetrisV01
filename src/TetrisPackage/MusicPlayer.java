package TetrisPackage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;


public class MusicPlayer {

    private Board board;

    File file = new File("data/music.wav");
    File gameOver = new File("data/gameover.wav");
    public static boolean MusicState = false;

    AudioInputStream AudioStream;
    {
        try {
            AudioStream = AudioSystem.getAudioInputStream(file);
            //AudioStream = AudioSystem.getAudioInputStream(gameOver);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioStream);
            if(MusicState){
                clip.start();
            }
            else{
                clip.stop();
            }
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
}

