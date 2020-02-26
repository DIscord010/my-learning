package club.csiqu.patterns.chain;

/**
 * 责任链模式
 * <p>
 * 本例中使用记录器持有下一个记录器的形式实现责任链模式。
 * 但在观察中发现，大部分框架都是使用集合进行遍历的方式实现责任链模式，
 * 方便增加责任。但是无法在责任链进行中停止。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/3 9:32
 */
public class ChainMain {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}