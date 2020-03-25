package club.csiqu.learn.pattern.adapter;

/**
 * @author chensiqu
 * @since 2019/5/20 17:42
 */
public interface MediaPlayer {

    /**
     * 播放
     *
     * @param audio    播放格式
     * @param fileName 文件名称
     */
    void play(String audio, String fileName);

}