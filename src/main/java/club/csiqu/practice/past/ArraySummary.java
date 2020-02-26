package club.csiqu.practice.past;

import java.util.*;

/**
 * @author chensiqu
 * @since 2019/3/8 17:12
 */
@SuppressWarnings("unused")
public class ArraySummary {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     * @param array 数组
     * @return 数字
     */
    public static int moreThanHalfNum(int[] array) {

        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        for (int i1 : array) {
            hashMap.put(i1, 0);
        }
        if (hashMap.size() > array.length >> 1 + 1) {
            return 0;
        }
        for (int i1 : array) {
            hashMap.put(i1, hashMap.get(i1) + 1);
        }
        for (int i1 : array) {
            if (hashMap.get(i1) > array.length >> 1) {
                return i1;
            }
        }
        return 0;
    }

    /**
     * 输入 n个整数，找出其中最小的 K个数。
     *
     * @param input 数组
     * @param k     个数
     * @return ArrayList
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        if (k > input.length) {
            return null;
        }
        Arrays.sort(input);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。实际上为排序问题。
     *
     * @param numbers 正整数数组
     * @return String
     */
    public static String printMinNumber(int[] numbers) {
        StringBuilder result = new StringBuilder();
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        String temp;
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (minNumber(strings[i], strings[j])) {
                    temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        for (String string : strings) {
            result.append(string);
        }
        return result.toString();
    }

    /**
     * 确定两个字符串哪个该放在前面
     *
     * @param str1 String
     * @param str2 String
     * @return boolean str1 > str2
     */
    private static boolean minNumber(String str1, String str2) {

        StringBuilder str1Builder1 = new StringBuilder(str1);
        StringBuilder str1Builder2 = new StringBuilder(str2);
        while (str1Builder1.length() < str1Builder2.length()) {
            str1Builder1.append(str1Builder1.charAt(0));
        }
        while (str1Builder1.length() > str1Builder2.length()) {
            str1Builder2.append(str1Builder2.charAt(0));
        }
        return Integer.parseInt(str1Builder1.toString()) >
                Integer.parseInt(str1Builder2.toString());
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，
     * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数 P。
     * 并将 P对 1000000007取模的结果输出。即输出 P%1000000007。
     *
     * @param array 数组
     * @return P%1000000007
     */
    public int inversePairs(int[] array) {
        int[] temp = new int[array.length];
        inversePairs(array, 0, array.length - 1, temp);
        return inversePairsCount;
    }

    /** 逆序对数量 */
    private int inversePairsCount = 0;

    /**
     * 求逆序对的数量，用归并实现。
     *
     * @param array 数组
     * @param left  开始下标
     * @param right 结束下标
     * @param temp  辅助数组
     */
    private void inversePairs(int[] array, int left, int right, int[] temp) {
        int mid;
        if (right > left) {
            mid = (left + right) >> 1;
            // 左序列递归
            inversePairs(array, left, mid, temp);
            // 右序列递归
            inversePairs(array, mid + 1, right, temp);
            // 对两个序列进行合并
            inversePairsCore(array, left, mid, right, temp);
        }

    }

    /**
     * 求逆序对的数量，归并核心。
     *
     * @param array 数组
     * @param left  开始下标
     * @param mid   中间下标
     * @param right 结束下标
     * @param temp  辅助数组
     */
    private void inversePairsCore(int[] array, int left, int mid, int right, int[] temp) {
        // 左序列开始下标
        int i = left;
        // 右序列开始下标
        int j = mid + 1;
        int index = 0;
        // 进行循环比较，每次将小的加入放入 temp数组
        while (i <= mid && j <= right) {
            if (array[i] > array[j]) {
                temp[index++] = array[j++];
                inversePairsCount += (mid - i + 1);
                inversePairsCount = inversePairsCount > 1000000007
                        ? inversePairsCount % 1000000007 : inversePairsCount;
            } else {
                temp[index++] = array[i++];

            }
        }
        // 结束后，可能出现的左序列剩余部分
        while (i <= mid) {
            temp[index] = array[i];
            index++;
            i++;
        }
        // 结束后，可能出现的右序列剩余部分
        while (j <= right) {
            temp[index] = array[j];
            index++;
            j++;
        }
        index = 0;
        // 将排序结果 temp数组复制回 array数组
        while (left <= right) {
            array[left] = temp[index];
            left++;
            index++;
        }
    }

    /**
     * 统计一个数字在排序数组中出现的次数
     *
     * @param array 数组
     * @param k     目标数字
     * @return 次数
     */
    public static int getNumberOfK(int[] array, int k) {
        int count = 0;
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == k) {
                break;
            }
        }
        for (; i < array.length; i++) {
            if (array[i] != k) {
                return count;
            }
            count++;
        }
        return count;
    }

    /**
     * 一个整型数组里除了两个数字之外，
     * 其他的数字都出现了偶数次。
     * 请写程序找出这两个只出现一次的数字。
     *
     * @param array 数组
     * @param num1  {@code num1},{@code num2}分别为长度为 1的数组。
     * @param num2  将 {@code num1[0]},{@code num2[0]}设置为返回结果
     */
    public static void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i1 : array) {
            if (map.containsKey(i1)) {
                map.put(i1, map.get(i1) + 1);
            } else {
                map.put(i1, 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i1 : array) {
            if (map.get(i1) == 1) {
                arrayList.add(i1);
            }
        }
        num1[0] = arrayList.get(0);
        num2[0] = arrayList.get(1);
    }

    /**
     * 0为大小王可代替任何数，如果为顺子则输出 {@code true}。
     *
     * @param numbers 数组
     * @return 是否为顺子
     */
    public static boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        int[] ints = new int[13];
        for (int i1 : numbers) {
            ints[i1]++;
        }
        int i = 1;
        for (; i < 13; i++) {
            if (ints[i] != 0) {
                break;
            }
        }
        //System.out.println(i);
        for (int j = 0; j < numbers.length; j++) {
            if (ints[i] > 1) {
                return false;
            } else if (ints[i] == 0) {
                if (ints[0] == 0) {
                    return false;
                } else {
                    ints[0]--;
                }
            }
            i++;
        }
        return true;
    }

    /**
     * 孩子们的游戏(圆圈中最后剩下的数)
     *
     * @param n 人数
     * @param m 报到 m-1出列
     * @return 最后一个下标
     */
    private static int lastRemaining(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int temp = 0;
        int i = 0;
        while (list.size() > 1) {
            System.out.println(i + " " + temp);
            if (temp == m - 1) {
                list.remove(i);
                //System.out.println(list.size());
                i--;
            }
            temp++;
            i++;
            if (temp == m) {
                temp = 0;
            }
            if (i == list.size()) {
                //System.out.print("dddd");
                i = 0;
            }
        }
        return list.get(0);
    }

    /**
     * 请找出数组中任意一个重复的数字
     *
     * @param numbers     数组
     * @param length      长度
     * @param duplication 返回结果
     * @return 第一个重复的数字
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (length == 0) {
            return false;
        }
        int[] ints = new int[length];
        for (int number : numbers) {
            if (ints[number] == 0) {
                ints[number]++;
            } else {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(getNumberOfK(new int[]{1, 2, 3, 3, 3, 3}, 3));
        //System.out.println(isContinuous(new int[]{2, 3, 5, 7, 0, 0}));
        //System.out.println(lastRemaining(5, 3));
    }
}