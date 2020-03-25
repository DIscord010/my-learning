package club.csiqu.learn.pattern.adapter;

/**
 * @author chensiqu
 * @since 2019/5/20 18:02
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    MediaAdapter(String audioType) {

        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audio, String fileName) {

        if ("vlc".equalsIgnoreCase(audio)) {
            advancedMediaPlayer.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audio)) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}