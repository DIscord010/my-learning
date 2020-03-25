package club.csiqu.learn.pattern.chain;

/**
 * 责任链模式
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/3 9:14
 */
public abstract class AbstractLogger {

    static final int INFO = 1;

    static final int DEBUG = 2;

    static final int ERROR = 3;

    int level;

    private AbstractLogger nextLogger;

    void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}