package club.csiqu.learn.framework.spring.ioc.example.service.impl;

import club.csiqu.learn.framework.spring.ioc.example.service.SayGoodService;
import org.springframework.stereotype.Component;

/**
 * @author Siqu Chen 2021/3/4
 * @since 1.0.0
 */
@Component
public class SayGoodServiceImpl implements SayGoodService {

    @Override
    public String sayGood() {
        return "good";
    }
}