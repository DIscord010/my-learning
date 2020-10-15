package club.csiqu.learn.concurrent.mock.server.command;

import club.csiqu.learn.concurrent.mock.server.dao.IndexDao;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public class QueryCommand extends BaseCommand {

    private final IndexDao indexDao = new IndexDao();

    public QueryCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        if (command.length == 3) {
            return indexDao.query(command[1], command[2]);
        } else if (command.length == 4) {
            return indexDao.query(command[1], command[2], Short.parseShort(command[3]));
        } else {
            return "error command.";
        }
    }
}