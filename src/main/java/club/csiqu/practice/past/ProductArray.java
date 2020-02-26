package club.csiqu.practice.past;

public class ProductArray {

    public int[] multiply(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = 1;
            for (int j = 0; j < array.length; j++) {
                if (j != i) {
                    result[i] = array[j] * result[i];
                }
            }
        }
        return result;
    }
}