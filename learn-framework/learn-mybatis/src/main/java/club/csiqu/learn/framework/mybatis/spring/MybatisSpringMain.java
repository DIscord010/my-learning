package club.csiqu.learn.framework.mybatis.spring;

import club.csiqu.learn.framework.mybatis.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring整合Mybatis bean注册流程梳理
 *
 * @author Siqu Chen 2020/2/18
 * @since 1.0
 */
public class MybatisSpringMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisSpringMain.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring/mybatis/spring-mybatis.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        LOGGER.info(userMapper.getByUserName("admin").getPassword());
    }
}