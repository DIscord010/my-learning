package club.csiqu.learn.pattern.chain;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/3 9:31
 */
public class FileLogger extends AbstractLogger {

    FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}