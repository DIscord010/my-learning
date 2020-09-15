package club.csiqu.learnweb.module.retrofit.manager;

import club.csiqu.learnweb.LearnWebApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @author Siqu Chen 2020/9/15
 * @since 1.0
 */
class WeatherManagerTest extends LearnWebApplicationTests {

    @Autowired
    WeatherManager weatherManager;

    @Test
    void testGetWeatherByCityCode() throws IOException {
        Assertions.assertEquals(200, weatherManager.getWeatherByCityCode("CHSH000000").execute().code());
    }
}