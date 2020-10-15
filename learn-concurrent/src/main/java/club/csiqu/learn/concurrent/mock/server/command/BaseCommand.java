package club.csiqu.learn.concurrent.mock.server.command;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public abstract class BaseCommand {

    protected final String[] command;

    public BaseCommand(String[] command) {
        this.command = command;
    }

    public abstract String execute();
}