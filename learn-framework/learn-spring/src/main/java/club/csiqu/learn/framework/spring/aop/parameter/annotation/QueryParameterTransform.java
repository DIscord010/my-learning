package club.csiqu.learn.framework.spring.aop.parameter.annotation;

import java.lang.annotation.*;

/**
 * 被此注解注解的属性需要进行转义装换
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 17:16
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryParameterTransform {}