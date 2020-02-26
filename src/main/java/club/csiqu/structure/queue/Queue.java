package club.csiqu.structure.queue;

/**
 * 使用数组实现的队列
 *
 * @param <E> 队列内元素类型
 */
class Queue<E> {

    private Object[] queArray;

    private int maxSize;

    private int length;

    private int frontIndex;

    private int rearIndex;

    /**
     * 初始化队列
     *
     * @param maxSize 队列长度
     */
    private Queue(int maxSize) {
        this.maxSize = maxSize;
        queArray = new Object[maxSize];
        length = 0;
        frontIndex = 0;
        rearIndex = -1;
    }

    /**
     * 判满
     *
     * @return 是否满队列
     */
    private boolean isFull() {
        return (length == maxSize);
    }

    /**
     * 判满
     *
     * @return 是否空队列
     */
    private boolean isEmpty() {
        return (length == 0);
    }

    /**
     * 插入队列元素
     *
     * @param element 插入的元素
     * @throws Exception 满队列异常
     */
    public void add(E element) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满，不能进行插入操作！");
        }
        if (rearIndex == maxSize - 1) {
            rearIndex = -1;
        }
        queArray[++rearIndex] = element;
        length++;
    }

    /**
     * 移除队列元素
     *
     * @return 移除的队列元素
     * @throws Exception 空队列异常
     */
    @SuppressWarnings("unchecked")
    private E remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空，不能进行移除操作！");
        }
        Object element = queArray[frontIndex++];
        if (frontIndex == maxSize) {
            frontIndex = 0;
        }
        length--;
        return (E) element;
    }

    /**
     * 查看队头元素
     *
     * @return 队头元素
     * @throws Exception 空队列异常
     */
    @SuppressWarnings("unchecked")
    private E peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        return (E) queArray[frontIndex];
    }

    /**
     * 获取队列长度
     *
     * @return 队列长度
     */
    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        Queue<String> myQueue = new Queue<>(5);
        try {
            myQueue.add("123");
            myQueue.add("124");
            myQueue.add("125");
            myQueue.add("126");
            myQueue.add("chen");
            myQueue.remove();
            System.out.println(myQueue.remove());
            myQueue.remove();
            myQueue.remove();
            myQueue.add("128");
            System.out.println(myQueue.peek());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}