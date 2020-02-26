package club.csiqu.framework.spring.demo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class HelloBeforeMethod implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) {
        System.out.println("hello");
    }
}