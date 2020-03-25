package club.csiqu.learn.pattern.adapter;

/**
 * @author chensiqu
 * @since 2019/5/20 18:07
 */
public class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String audio, String fileName) {

        if ("mp3".equalsIgnoreCase(audio)) {
            System.out.println("play mp3 file. name: " + fileName);
        } else if ("vlc".equalsIgnoreCase(audio)
                || "mp4".equalsIgnoreCase(audio)) {

            MediaAdapter mediaAdapter = new MediaAdapter(audio);
            mediaAdapter.play(audio, fileName);
        } else {
            System.out.println("invalid media.");
        }

    }
}