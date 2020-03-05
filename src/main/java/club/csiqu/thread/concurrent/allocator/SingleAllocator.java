package club.csiqu.thread.concurrent.allocator;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户资源锁
 *
 * @author chensiqu
 * @since 2019/3/27 9:54
 */
class SingleAllocator {

    /** 资源集合 */
    private List<Account> als = new ArrayList<>();

    /**
     * 申请两个资源
     *
     * @param from 转账账户
     * @param to   目标账户
     */
    synchronized void apply(Account from, Account to) {
        while (als.contains(from) || als.contains(to)) {
            try {
                // 释放进入 synchronized方法所获取的锁
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        als.add(from);
        als.add(to);
    }

    /**
     * 归还两个资源
     */
    synchronized void free(Account account1, Account account2) {
        als.remove(account1);
        als.remove(account2);
        // 唤醒所有 wait中的线程
        notifyAll();
    }

    /**
     * 获取单例实例，使用静态内部类实现懒加载单例。
     *
     * @return {@code instance}单例对象
     */
    static SingleAllocator getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {

        private static SingleAllocator instance = new SingleAllocator();
    }

    private SingleAllocator() {

    }
}