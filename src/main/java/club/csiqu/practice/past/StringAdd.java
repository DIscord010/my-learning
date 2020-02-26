package club.csiqu.practice.past;

import java.util.Scanner;

public class StringAdd {

    public static String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        int l = a.length() - b.length();
        // 将长度补齐
        if (l < 0) {
            StringBuilder aBuilder = new StringBuilder(a);
            for (int i = 0; i < Math.abs(l); i++) {
                aBuilder.insert(0, "0");
            }
            a = aBuilder.toString();
        } else {
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i < l; i++) {
                bBuilder.insert(0, "0");
            }
            b = bBuilder.toString();
        }
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) + b.charAt(i) + carry - '0' - '0';
            if (x >= 2) {
                result.append((char) ('0' + x - 2));
                carry = 1;
            } else {
                result.append((char) ('0' + x));
                carry = 0;
            }
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String a = scanner.next();
        String b = scanner.next();
        System.out.print(add(a, b));
    }
}