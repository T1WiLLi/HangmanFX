package App;

import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

/**
 * The AudioPlayer class provides methods for playing audio from a file.
 */
public class AudioPlayer {
    
    private static Clip clip;
    private static File audioFile;

    /**
     * Initializes the audio player with the specified audio file.
     *
     * @param audioFilePath The file path of the audio to be played.
     */
    public static void audioPlayer(String audioFilePath) {
        audioFile = new File(audioFilePath);
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile)) {
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
