package club.csiqu.patterns.adapter;

/**
 * @author chensiqu
 * @since 2019/5/20 17:44
 */
public class VlcPlayer implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        System.out.println("playing vlc file. name: " + fileName);
    }

    @Override
    public void playMp4(String filename) {
        // do nothing
    }
}