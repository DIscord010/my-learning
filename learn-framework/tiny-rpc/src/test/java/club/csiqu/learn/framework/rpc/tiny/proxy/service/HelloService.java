package club.csiqu.learn.framework.rpc.tiny.proxy.service;

import club.csiqu.learn.framework.rpc.tiny.proxy.bean.Person;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:42
 */
public interface HelloService {

    String sayHello(Person person);

}