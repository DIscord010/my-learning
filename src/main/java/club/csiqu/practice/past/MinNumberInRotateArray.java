package club.csiqu.practice.past;

public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {

        if (array == null) {
            return 0;
        }
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return 0;
    }
}