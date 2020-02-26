package club.csiqu.practice.past;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class PrintMatrix {

    private static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] index = new int[]{0, 0, matrix.length - 1, matrix[0].length - 1};

        while (index[0] <= index[2] && index[1] <= index[3]) {
            printCircle(matrix, arrayList, index);
            index[0]++;
            index[1]++;
            index[2]--;
            index[3]--;
        }

        return arrayList;
    }

    /**
     * 打印矩形一圈
     *
     * @param matrix    二位数组
     * @param arrayList 结果集
     * @param index     点位
     * @return 结果集
     */
    private static ArrayList<Integer>
    printCircle(int[][] matrix, ArrayList<Integer> arrayList, int[] index) {

        for (int i = index[0]; i <= index[3]; i++) {
            arrayList.add(matrix[index[0]][i]);
        }
        for (int i = index[1] + 1; i <= index[2]; i++) {
            arrayList.add(matrix[i][index[3]]);
        }
        // 判断是否是一行的情况
        if (index[0] != index[2]) {
            for (int i = index[3] - 1; i >= index[0]; i--) {
                arrayList.add(matrix[index[2]][i]);
            }
        }
        // 判断是否是一列的情况
        if (index[1] != index[3]) {
            for (int i = index[2] - 1; i >= index[0] + 1; i--) {
                arrayList.add(matrix[i][index[0]]);
            }
        }
        //arrayList.add(0);
        return arrayList;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {1,},
                {6,},
                {11,}};
        ArrayList<Integer> arrayList = printMatrix(arrays);
        for (Integer i : arrayList) {
            System.out.print(" " + i);
        }
    }
}