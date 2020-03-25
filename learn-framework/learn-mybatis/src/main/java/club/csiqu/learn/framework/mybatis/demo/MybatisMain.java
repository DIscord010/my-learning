package club.csiqu.learn.framework.mybatis.demo;

import club.csiqu.learn.framework.mybatis.demo.entity.User;
import club.csiqu.learn.framework.mybatis.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * 单独使用 Mybatis框架进行数据库的查询。
 * sqlsession中持有 executor，executor中持有 transaction，transaction中持有 dataSource以及 connection。
 * Mybatis在第一次真正执行查询语句时，才会从使用 {@link DataSource#getConnection()}中获取数据库连接对象。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 17:46
 */
public class MybatisMain {

    public static void main(String[] args) throws IOException {
        // 配置文件文件路径
        String resource = "mybatis/mybatis-config.xml";
        // 配置文件文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过配置文件，初始化 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取 SqlSession，包含了面向数据库执行 SQL命令所需的所有方法，通过 SqlSession实例来直接执行已映射的 SQL语句
        // 原始的方式,旧版本 MyBatis
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 原始的使用方式，直接通过映射的 SQL语句来进行查询
            // 第一个参数为 [命名空间].[语句 id]，第二个参数为该 SQL语句需要的参数
            User user = session.selectOne(
                    "club.csiqu.framework.mybatis.demo.mapper.UserMapper.getByUserName", "admin");
            System.out.println(user.getPassword());
        }
        // 简洁的方式，使用正确描述每个语句的参数和返回值的接口
        // 可以执行更清晰和类型安全的代码，而且还不用担心易错的字符串字面值以及强制类型转换
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getByUserName("admin");
            System.out.println(user.getPassword());
        }
    }
}