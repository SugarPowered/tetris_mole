import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;

public class Hudba {
    private Clip clip;
    public Hudba() {
        
    }
    
    public void hudbaMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //priradenie súboru s hudbou
        File subor = new File("Tetris.wav");
        //získanie inputu pre hudbu
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(subor);
        //priradenie hudby do "prehrávača"
        this.clip = AudioSystem.getClip();
        this.clip.open(audioStream);
        //začatie prehrávania
        this.clip.start();
        //resetovanie hudby po jej skončení
        this.clip.loop(10000);
    }
}
