package club.csiqu.learn.basis.jdbc;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Siqu Chen 2020/7/16
 * @since 1.0
 */
class JdbcTemplateTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcTemplateTest.class);

    /**
     * 测试创建数据库连接实例对象的代价
     * <p>
     * 本例创建数据库连接实例对象花费的时间大约为 360ms左右，而执行查询语句只花费了 40ms左右。
     * 过去版本需要使用 {@link Class#forName(String)}手动加载驱动，而新版本使用 SPI机制，进行驱动类的加载。
     * 在注册多数据库驱动的情况下，{@link DriverManager#getConnection(String, String, String)}会循环所有已注册驱动，
     * 进行获取数据库连接对象。
     */
    @Test
    void testCreat() throws SQLException {
        String sql = "select * from t_user where username = 'admin'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate("jdbc:mysql://123.207.89.169/max",
                "root",
                "Chensiqu@123++");
        Stopwatch stopwatch = Stopwatch.createStarted();
        try (Connection connection = jdbcTemplate.createConnect()) {
            stopwatch.stop();
            LOGGER.info("Create connection cost:{}", stopwatch);
            stopwatch.reset();
            stopwatch.start();

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                stopwatch.stop();
                LOGGER.info("Exec SQL Costs: {} ms", stopwatch);
                resultSet.next();
                Assertions.assertEquals("123456", resultSet.getString(2));
            }
        }
    }
}