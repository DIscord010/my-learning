package club.csiqu.practice.past;

import java.util.Scanner;

public class StringRotation {

    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in, "UTF-8");
        str = scanner.next();
        String[] strArr = str.split(";");

        for (int i = 1; i < strArr[0].length() - 1; i++) {
            String begin = strArr[0].substring(0, i);
            String end = strArr[0].substring(i);
            String get = end + begin;
            if (get.equals(strArr[1])) {
                System.out.print("true");
                return;
            }
        }
        System.out.print("false");
    }
}