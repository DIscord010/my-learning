package club.csiqu.framework.dubbo.my.rpc.api.service;

import club.csiqu.framework.dubbo.my.rpc.api.bean.Person;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:42
 */
public interface HelloService {

    String sayHello(Person person);

}