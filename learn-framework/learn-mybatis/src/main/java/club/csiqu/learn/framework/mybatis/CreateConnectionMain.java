package club.csiqu.learn.framework.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 测试创建数据库连接实例对象的代价
 * <p>
 * 本例创建数据库连接实例对象花费的时间大约为 1800ms左右，而执行查询语句只花费了 60ms左右。
 * 过去版本需要使用 {@link Class#forName(String)}手动加载驱动，而新版本使用 SPI机制，进行驱动类的加载。
 * 在注册多数据库驱动的情况下，{@link DriverManager#getConnection(String, String, String)}会循环所有已注册驱动，
 * 进行获取数据库连接对象。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/17 16:03
 */
@SuppressWarnings({"SqlNoDataSourceInspection"})
public class CreateConnectionMain {

    public static void main(String[] args) throws Exception {
        String sql = "select * from t_user where username = 'admin'";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        long beforeTimeOffset;
        long afterTimeOffset;
        long executeTimeOffset;

        beforeTimeOffset = System.currentTimeMillis();
        connection = DriverManager.getConnection("jdbc:mysql://123.207.89.169/max", "root", "Chensiqu@123++");
        afterTimeOffset = System.currentTimeMillis();
        System.out.println("Create Costs:\t\t" + (afterTimeOffset - beforeTimeOffset) + " ms");

        statement = connection.prepareStatement(sql);
        // 查询，得出结果集
        resultSet = statement.executeQuery();
        executeTimeOffset = System.currentTimeMillis();
        System.out.println("Exec Costs:\t\t" + (executeTimeOffset - afterTimeOffset) + " ms");

        resultSet.next();
        System.out.println(resultSet.getString(2));

        resultSet.close();
        statement.close();
        connection.close();
    }
}