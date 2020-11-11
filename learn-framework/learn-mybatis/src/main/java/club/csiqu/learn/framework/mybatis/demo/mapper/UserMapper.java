package club.csiqu.learn.framework.mybatis.demo.mapper;

import club.csiqu.learn.framework.mybatis.demo.entity.User;

import java.util.List;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 18:05
 */
public interface UserMapper {

    User getByUserName(String userName);

    List<User> listByPassword(String password);

}