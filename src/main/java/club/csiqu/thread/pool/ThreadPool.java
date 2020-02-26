package club.csiqu.thread.pool;

import java.util.concurrent.BlockingQueue;

/**
 * 简单实现线程池
 *
 * @author chensiqu
 * @since 2019/6/28 17:21
 */
class ThreadPool {

    /** 阻塞队列实现生产者-消费者模式 */
    private BlockingQueue<Runnable> workQueue;

    ThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {

        this.workQueue = workQueue;
        // 创建工作线程
        for (int i = 0; i < poolSize; i++) {
            WorkerThread work = new WorkerThread();
            work.start();
        }

    }

    void execute(Runnable command) {
        try {
            // 将需要执行的操作添加进队列中
            workQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class WorkerThread extends Thread {

        @SuppressWarnings("InfiniteLoopStatement")
        @Override
        public void run() {

            // 循环从队列中取出任务执行
            while (true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                }
            }
        }
    }
}