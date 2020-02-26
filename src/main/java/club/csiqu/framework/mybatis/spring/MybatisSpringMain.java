package club.csiqu.framework.mybatis.spring;

import club.csiqu.framework.mybatis.demo.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring整合Mybatis bean注册流程梳理
 *
 * @author Siqu Chen 2020/2/18
 * @since 1.0.0
 */
public class MybatisSpringMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring/mybatis/spring-mybatis.xml");
        UserMapper userMapper = (UserMapper)context.getBean("userMapper");
        System.out.println(userMapper.getByUserName("admin").getPassword());
    }
}