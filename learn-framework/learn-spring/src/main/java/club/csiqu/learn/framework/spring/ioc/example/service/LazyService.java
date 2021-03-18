package club.csiqu.learn.framework.spring.ioc.example.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Siqu Chen 2021/3/18
 * @since 1.0.0
 */
@Component
public class LazyService {

    @Lazy
    @Resource
    private SayGoodService lazySayGoodService;

    @Resource
    private SayGoodService sayGoodService;


    public SayGoodService getLazySayGoodService() {
        return lazySayGoodService;
    }

    public SayGoodService getSayGoodService() {
        return sayGoodService;
    }
}