package club.csiqu.patterns.chain;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/3 9:31
 */
public class ErrorLogger extends AbstractLogger {

    ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}