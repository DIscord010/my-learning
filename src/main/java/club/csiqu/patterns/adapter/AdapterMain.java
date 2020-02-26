package club.csiqu.patterns.adapter;

/**
 * 适配器模式
 * <p>
 * 本质上就是进行接口转换，在不重构的情况下，增加一个所需接口实现类。
 * 但是内部适配成了另一个接口的实现。
 * 适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。
 * 如无必要，应该进行重构而不是使用适配器模式。
 *
 * @author chensiqu
 * @since 2019/5/20 18:10
 */
public class AdapterMain {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "mp3 file");
        audioPlayer.play("mp4", "mp4 file");
        audioPlayer.play("vlc", "vlc file");
        audioPlayer.play("avi", "avi file");
    }
}