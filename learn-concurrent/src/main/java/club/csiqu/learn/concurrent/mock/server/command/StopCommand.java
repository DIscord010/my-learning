package club.csiqu.learn.concurrent.mock.server.command;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public class StopCommand extends BaseCommand {

    public StopCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        return "server stopped.";
    }
}