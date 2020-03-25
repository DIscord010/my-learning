package club.csiqu.learn.pattern.singleton;

/**
 * @author chensiqu
 * @since 2019/3/13 11:47
 */
public class SingletonMain {

    public static void main(String[] args) {
        SampleSingleton sampleSinge = SampleSingleton.getInstance();
        sampleSinge.showMessage();
    }
}