package club.csiqu.practice.past;

/**
 * 不用 +进行加法操作
 */
public class SpecialAdd {

    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(188, 388));
    }
}