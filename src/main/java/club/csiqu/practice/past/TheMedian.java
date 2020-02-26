package club.csiqu.practice.past;

import java.util.ArrayList;

/**
 * 如何得到一个数据流中的中位数
 * <p>
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * @author chensiqu
 * @since 2019/3/14 16:40
 */
public class TheMedian {

    private ArrayList<Integer> list = new ArrayList<>();

    private void insert(Integer num) {
        if (list.size() == 0) {
            list.add(num);
        } else {
            if (num < list.get(0)) {
                list.add(0, num);
                return;
            }
            int i = list.size() - 1;
            // 前移找到需要插入的位置 保障有序
            while (i >= 0) {
                if (num > list.get(i)) {
                    list.add(i + 1, num);
                    break;
                }
                i--;
            }
        }
    }

    private Double getMedian() {
        return list.size() % 2 != 0 ? Double.valueOf(list.get(list.size() >> 1)) :
                (list.get(list.size() >> 1) - 1) + (list.get(list.size() >> 1)) / 2.0;
    }

    public static void main(String[] args) {
        TheMedian theMedian = new TheMedian();
        theMedian.insert(5);
        theMedian.insert(2);
        theMedian.insert(3);
        System.out.println(theMedian.getMedian());
    }
}