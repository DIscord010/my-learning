package club.csiqu.learn.concurrent.reconciliation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author chensiqu
 * @since 2019/7/4 17:05
 */
public class OrderServiceImpl implements OrderService {

    /** 日志处理 */
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public String getOrders() {

        int i = 0;
        // 空循环模拟操作
        for (; i < 1000; i++) {
            // do something

        }

        return new Date().toString() + i;
    }

    @Override
    public String getDeliveryOrders() {
        int i = 0;
        // 空循环模拟操作
        for (; i < 1000; i++) {
            // do something

        }
        return new Date().toString() + i;
    }

    @Override
    public Boolean check(String pOrders, String dOrders) {
        return (pOrders.equals(dOrders));
    }

    @Override
    public void save(String differernt) {
        logger.info(differernt);
    }
}