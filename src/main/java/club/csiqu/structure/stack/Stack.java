package club.csiqu.structure.stack;

/**
 * 固定长度的栈，由数组实现。
 *
 * @param <E> 栈内元素类型
 * @author chensiqu
 */
class Stack<E> {

    /** 栈的大小 */
    private int size;

    /** 栈顶元素下标 */
    private int topIndex;

    /** 栈的数组容 */
    private Object[] stackArray;

    /**
     * 构造函数
     *
     * @param size 栈的初始大小
     */
    private Stack(int size) {
        stackArray = new Object[size];
        topIndex = -1;
        this.size = size;
    }

    /**
     * 入栈
     *
     * @param element 栈顶元素
     */
    private void push(E element) {
        stackArray[++topIndex] = element;
    }

    /**
     * 出栈
     *
     * @return 栈顶元素
     */
    @SuppressWarnings("unchecked")
    private E pop() {
        return (E) stackArray[topIndex--];
    }

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    @SuppressWarnings("unchecked")
    private E peek() {
        return (E) stackArray[topIndex];
    }

    /**
     * 判断是否为空栈
     *
     * @return 是否为空
     */
    private boolean isEmpty() {
        return (topIndex == -1);

    }

    /**
     * 判断是否满栈
     *
     * @return 是否已满
     */
    private boolean isFull() {
        return (topIndex == this.size - 1);
    }

    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>(5);
        myStack.push("123");
        myStack.push("abc");
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.isFull());
        System.out.println(myStack.isEmpty());
    }
}