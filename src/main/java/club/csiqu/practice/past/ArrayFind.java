package club.csiqu.practice.past;

/**
 * @author chensiqu
 */
public class ArrayFind {

    private static boolean find(int target, int[][] array) {
        // int row = array.length;
        int column = array[0].length;
        for (int[] ints : array) {
            for (int j = 0; j < column; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 5;
        System.out.print(find(target, array));
    }
}