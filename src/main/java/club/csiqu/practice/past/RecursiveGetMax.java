package club.csiqu.practice.past;

public class RecursiveGetMax {

    public static int sort(int[] array, int length) {
        int max;
        if (length == 1) {
            return array[0];
        } else {
            max = sort(array, length - 1);
            if (max < array[length - 1]) {
                max = array[length - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {30, 200, 65, 250, 87, 99, 78, 45, 71, 15};
        System.out.print(RecursiveGetMax.sort(arr, arr.length));
    }
}