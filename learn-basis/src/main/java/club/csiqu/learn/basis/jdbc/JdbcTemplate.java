package club.csiqu.learn.basis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Siqu Chen 2020/6/24
 * @since 1.0
 */
public class JdbcTemplate {

    private final String url;

    private final String user;

    private final String password;


    public JdbcTemplate(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * 获取数据库连接对象
     */
    public Connection createConnect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}