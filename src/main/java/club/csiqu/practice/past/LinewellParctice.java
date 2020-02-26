package club.csiqu.practice.past;

public class LinewellParctice {

    private static int count() {
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
                count++;
            }
        }
        return count;
    }

    private static void saveMax(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[0]) {
                temp = array[0];
                array[0] = array[i];
                array[i] = temp;
            }
        }
    }

    private static int[] countChar(String string) {
        int countN = 0;
        int countO = 0;
        int length = string.length();
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == 'n') {
                countN++;
            }
            if (string.charAt(i) == 'o') {
                countO++;
            }
        }
        return new int[]{countN, countO};
    }

    public static void main(String[] args) {
        System.out.println(count());
        int[] array = new int[]{1, 5, 9, 8};
        saveMax(array);
        System.out.println(array[0]);
        int[] findArray = countChar("want you to one thing");
        System.out.println(findArray[0] + " " + findArray[1]);
    }
}