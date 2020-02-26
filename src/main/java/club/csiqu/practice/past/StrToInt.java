package club.csiqu.practice.past;

public class StrToInt {

    private static int trToInt(String str) {
        int len = str.length();
        int i = 0;
        boolean temp = true;
        double result = 0;
        try {
            if (str.charAt(0) == '+') {
                i++;
            }
            if (str.charAt(0) == '-') {
                i++;
                temp = false;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return 0;
        }
        for (; i < len; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
            result = (str.charAt(i) - '0') * Math.pow(10, (len - i - 1)) + result;
        }
        if (!temp) {
            return (int) (result * -1);
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(trToInt("-2147483648"));
    }
}