package club.csiqu.learn.concurrent.mock.server.command;

import club.csiqu.learn.concurrent.mock.server.dao.IndexDao;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public class ReportCommand extends BaseCommand {

    private final IndexDao indexDao = new IndexDao();

    public ReportCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        return indexDao.report(command[1]);
    }
}