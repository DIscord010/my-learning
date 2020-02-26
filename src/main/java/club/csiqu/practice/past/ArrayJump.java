package club.csiqu.practice.past;

import java.util.Scanner;

public class ArrayJump {

    /**
     * 无需辅助数组，但是需要一个辅助变量。
     *
     * @param args 入口参数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String str = scanner.next();
        str = str.substring(1, str.length() - 1);
        String[] array = str.split(",");
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        for (int i = 0; ; ) {
            if (i >= arr.length || i < 0) {
                System.out.print("true");
                return;
            }
            if (arr[i] == 0) {
                System.out.print("false");
                return;
            }
            int temp = arr[i];
            arr[i] = 0;
            i = i + temp;
        }
    }
}