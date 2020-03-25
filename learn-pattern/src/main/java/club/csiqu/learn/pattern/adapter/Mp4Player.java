package club.csiqu.learn.pattern.adapter;

/**
 * @author chensiqu
 * @since 2019/5/20 17:57
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String filename) {
        System.out.println("playing mp4 file. name: " + filename);
    }
}