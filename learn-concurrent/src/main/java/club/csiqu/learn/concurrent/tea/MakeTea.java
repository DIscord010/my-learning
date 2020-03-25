package club.csiqu.learn.concurrent.tea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author chensiqu 2019/12/30
 * @since 1.0.0
 */
public class MakeTea {

    private static Logger LOGGER = LoggerFactory.getLogger(MakeTea.class);

    public void serialMakeTea() throws InterruptedException {
        LOGGER.info("T1：洗水壶...");
        TimeUnit.SECONDS.sleep(1);
        LOGGER.info("T1：烧开水...");
        TimeUnit.SECONDS.sleep(15);
        LOGGER.info("T2：洗茶壶...");
        TimeUnit.SECONDS.sleep(1);
        LOGGER.info("T2：洗茶杯...");
        TimeUnit.SECONDS.sleep(2);
        LOGGER.info("T2：拿茶叶...");
        TimeUnit.SECONDS.sleep(1);
        LOGGER.info("获取茶叶：龙井");
        LOGGER.info("泡茶...");
        LOGGER.info("上茶：龙井");
    }
}