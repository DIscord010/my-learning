package club.csiqu.learn.pattern.factory;

import java.util.Properties;

/**
 * @author Siqu Chen 2020/9/11
 * @since 1.0
 */
public class DefaultButtonFactory implements ButtonFactory {

    private static final String WINDOWS = "Windows";

    private static final String LINUX = "Linux";

    private static final String MAC = "Mac";

    @Override
    public Button createButton() {
        Properties props = System.getProperties();
        String os = props.getProperty("os.name");
        if (os.contains(WINDOWS)) {
            return new WindowsButton();
        }
        if (os.contains(LINUX)) {
            return new LinuxButton();
        }
        if (os.contains(MAC)) {
            return new MacOsButton();
        }
        throw new IllegalStateException("Unsupported operating system：" + os);
    }
}