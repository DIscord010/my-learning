package club.csiqu.learn.framework.spring.demo.aop.parameter.aspect;

import club.csiqu.learn.framework.spring.demo.aop.parameter.annotation.QueryParameterTransform;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Field;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 17:14
 */
public class ParameterAspect {

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
        for (Object o : objects) {
            if (!o.getClass().isAnnotationPresent(QueryParameterTransform.class)) {
                continue;
            }
            Field[] fields = o.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(QueryParameterTransform.class)) {
                    continue;
                }
                field.setAccessible(true);
                Object value = field.get(o);
                if (!(value instanceof String)) {

                    throw new IllegalArgumentException("QueryParameterTransform注解只能使用在String类型的字段上！");
                }
                field.set(o, value + "123");
            }
        }
        return joinPoint.proceed();
    }
}