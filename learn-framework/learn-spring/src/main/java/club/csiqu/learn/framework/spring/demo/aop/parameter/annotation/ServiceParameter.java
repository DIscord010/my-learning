package club.csiqu.learn.framework.spring.demo.aop.parameter.annotation;

import java.lang.annotation.*;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 17:22
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceParameter {}