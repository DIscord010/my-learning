package club.csiqu.learnweb.module.seckill.repository;

import club.csiqu.learnweb.LearnWebApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Siqu Chen 2021/3/1
 * @since 1.0.0
 */
class SeckillRepositoryTest extends LearnWebApplicationTests {

    @Autowired
    SeckillRepository seckillRepository;

    @Test
    void testGetNumberById() {
        Assertions.assertEquals(100, seckillRepository.getNumberById(1000));
    }
}