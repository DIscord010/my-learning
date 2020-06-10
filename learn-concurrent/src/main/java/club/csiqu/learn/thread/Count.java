package club.csiqu.learn.thread;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
public class Count {

    private long number = 0;

    public void add10k() {
        int index = 0;
        while (index++ < 10000) {
            number += 1;
        }
    }

    public long getNumber() {
        return number;
    }
}