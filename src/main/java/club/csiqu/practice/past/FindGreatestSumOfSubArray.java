package club.csiqu.practice.past;

public class FindGreatestSumOfSubArray {

    private static int findGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = 0;
        for (int i1 : array) {
            if (sum < 0) {
                sum = 0;
            }
            sum = sum + i1;
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findGreatestSumOfSubArray(
                new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}