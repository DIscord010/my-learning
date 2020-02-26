package club.csiqu.practice.past;

/**
 * @author chensiqu
 * @since 2019/3/11 11:47
 */
public class GetUglyNumber {

    private static int getUglyNumber(int index) {
        if (index == 0) {
            return 0;
        }
        int[] array = new int[index + 1];
        array[0] = 1;
        int i = 0;
        int i1 = 0, i3 = 0, i5 = 0;
        while (index > 0) {
            int m2 = array[i1] * 2;
            int m3 = array[i3] * 3;
            int m5 = array[i5] * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            array[i + 1] = min;
            if (min == m2) {
                i1++;
            }
            if (min == m3) {
                i3++;
            }
            if (min == m5) {
                i5++;
            }
            i++;
            index--;
        }
        return array[array.length - 2];
    }

    public static void main(String[] args) {
        //System.out.println(uglyNumber(6));
        System.out.println(getUglyNumber(1));
    }
}