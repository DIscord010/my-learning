package club.csiqu.practice.past;

public class ReOrderArray {

    private static void reOrderArray(int[] array) {
        int temp;
        int index = -1;

        for (int i = 0, length = array.length; i < length; i++) {
            if (array[i] % 2 == 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        // 整体采用插入排序的思维，分为确定序列和不确定序列，遇到奇数则插入已确定序列。
        for (int i = index + 1, length = array.length; i < length; i++) {
            if (array[i] % 2 != 0) {
                temp = array[i];
                // 将已确定偶数向后移动一个位置
                if (i - index >= 0) {
                    System.arraycopy(array, index, array, index + 1, i - index);
                }
                array[index] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 6, 1, 3, 5, 7};
        for (int i1 : array) {
            System.out.print(i1 + " ");
        }
        System.out.println();
        reOrderArray(array);
        for (int i1 : array) {
            System.out.print(i1 + " ");
        }
    }
}