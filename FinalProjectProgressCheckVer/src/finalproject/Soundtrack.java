package finalproject;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author dcpau
 */
public class Soundtrack extends Thread {

    private static Clip startmusic;
    private static Clip gameSound;
    private static Clip beep;
    private static Clip endmusic;
    private static Clip correctsound;
    private static Clip countdown;

    private static boolean titleMusicTrigger = false;
    private static boolean gameMusicTrigger = false;
    private static boolean endMusicTrigger = false;

    public static void titleMusicOn() {
        titleMusicTrigger = false;
        gameMusicTrigger = true;
        endMusicTrigger = true;
    }

    public static void gameMusicOn() {
        titleMusicTrigger = true;
        gameMusicTrigger = false;
        endMusicTrigger = true;
    }

    public static void endMusicOn() {
        titleMusicTrigger = true;
        gameMusicTrigger = true;
        endMusicTrigger = false;
    }

    public void initStart() {
        try {
            startmusic = AudioSystem.getClip();
            startmusic.open(AudioSystem.getAudioInputStream(new File("StartMusic.wav").getAbsoluteFile()
            ));
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void playStartmusic() {
        startmusic.setFramePosition(0);
        startmusic.start();
    }

    public void endStartMusic() {
        startmusic.stop();
    }

    public void initSoundtrack1() {
        try {
            gameSound = AudioSystem.getClip();
            gameSound.open(
                    AudioSystem.getAudioInputStream(new File("gameSoundtrack1.wav").getAbsoluteFile()
                    ));
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void endSoundtrack1() {
        gameSound.stop();
    }

    public void initEnd() {
        try {
            endmusic = AudioSystem.getClip();
            endmusic.open(
                    AudioSystem.getAudioInputStream(new File("endMusic.wav").getAbsoluteFile())
            );

        } catch (LineUnavailableException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void playEndmusic() {
        endmusic.setFramePosition(0);
        endmusic.start();
    }

    public void endEndmusic() {
        endmusic.stop();
    }

    public void initBeep() {
        try {
            beep = AudioSystem.getClip();
            beep.open(
                    AudioSystem.getAudioInputStream(new File("beep.wav").getAbsoluteFile()
                    ));
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void playBeep() {
        beep.setFramePosition(0);
        beep.start();
    }

    public void initCorrect() {
        try {
            correctsound = AudioSystem.getClip();
            correctsound.open(
                    AudioSystem.getAudioInputStream(new File("corrrect.wav").getAbsoluteFile()
                    ));
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initCountdown() {
        try {
            countdown = AudioSystem.getClip();
            countdown.open(
                    AudioSystem.getAudioInputStream(new File("countdown.wav").getAbsoluteFile()
                    ));
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Soundtrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void playCountdown() {
        countdown.setFramePosition(0);
        countdown.start();
    }

    public static void playCorrect() {
        correctsound.setFramePosition(0);
        correctsound.start();
    }

    public static void playSoundtrack() {
        gameSound.setFramePosition(0);
        gameSound.start();
    }

    public void run() {
        System.out.println("working sound");
        initStart();
        initSoundtrack1();
        initBeep();
        initEnd();
        initCorrect();
        initCountdown();
        while (true) {
            if(titleMusicTrigger == false) {
                endSoundtrack1();
                endEndmusic();
                if (startmusic.getFramePosition() == startmusic.getFrameLength()) {
                    playStartmusic();
                }
            } else if(gameMusicTrigger == false) {
                endStartMusic();
                endEndmusic();
                if (gameSound.getFramePosition() == gameSound.getFrameLength()) {
                    playSoundtrack();
                }
            } else if(endMusicTrigger == false) {
                endStartMusic();
                endSoundtrack1();
                if (endmusic.getFramePosition() == endmusic.getFrameLength()) {
                    playEndmusic();
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                endSoundtrack1();
                endEndmusic();
                return;
            }
        }
    }
}