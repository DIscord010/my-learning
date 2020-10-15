package club.csiqu.learn.concurrent.mock.server.dao;

import java.util.Random;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public class IndexDao {

    private final Random random = new Random();

    public String query(String countryCode, String indicatorCode) {
        return countryCode + indicatorCode + ":" + random.nextInt();
    }

    public String query(String countryCode, String indicatorCode, Short year) {
        return countryCode + indicatorCode + year + ":" + random.nextInt();
    }

    public String report(String indicatorCode) {
        return indicatorCode + random.nextInt();
    }
}