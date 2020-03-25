package club.csiqu.learn.framework.mybatis.demo.mapper;

import club.csiqu.learn.framework.mybatis.demo.entity.User;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 18:05
 */
public interface UserMapper {


    User getByUserName(String userName);

}