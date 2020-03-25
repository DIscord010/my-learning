package club.csiqu.learn.pattern.chain;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/3 9:18
 */
public class ConsoleLogger extends AbstractLogger {

    ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {

        System.out.println("Standard Console::Logger: " + message);
    }
}