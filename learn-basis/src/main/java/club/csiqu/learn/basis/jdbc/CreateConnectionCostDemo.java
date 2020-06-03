package club.csiqu.learn.basis.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试创建数据库连接实例对象的代价
 * <p>
 * 本例创建数据库连接实例对象花费的时间大约为 360ms左右，而执行查询语句只花费了 40ms左右。
 * 过去版本需要使用 {@link Class#forName(String)}手动加载驱动，而新版本使用 SPI机制，进行驱动类的加载。
 * 在注册多数据库驱动的情况下，{@link DriverManager#getConnection(String, String, String)}会循环所有已注册驱动，
 * 进行获取数据库连接对象。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/17 16:03
 */
public class CreateConnectionCostDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateConnectionCostDemo.class);

    @SuppressWarnings({"SqlNoDataSourceInspection", "SqlResolve"})
    public static void main(String[] args) throws SQLException {
        String sql = "select * from t_user where username = 'admin'";
        long beforeTimeOffset;
        long afterTimeOffset;
        long executeTimeOffset;
        beforeTimeOffset = System.currentTimeMillis();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://123.207.89.169/max",
                "root",
                "Chensiqu@123++")) {
            afterTimeOffset = System.currentTimeMillis();
            LOGGER.info("Create Connection Costs: {} ms", (afterTimeOffset - beforeTimeOffset));

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                // 查询，得出结果集
                executeTimeOffset = System.currentTimeMillis();
                LOGGER.info("Exec SQL Costs: {} ms", (executeTimeOffset - afterTimeOffset));
                resultSet.next();
                LOGGER.info("result password:{}", resultSet.getString(2));
            }
        }
    }
}