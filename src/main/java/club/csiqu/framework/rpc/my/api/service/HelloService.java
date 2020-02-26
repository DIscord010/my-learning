package club.csiqu.framework.rpc.my.api.service;

import club.csiqu.framework.rpc.my.api.bean.Person;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:42
 */
public interface HelloService {

    String sayHello(Person person);

    void helloWorld();
}