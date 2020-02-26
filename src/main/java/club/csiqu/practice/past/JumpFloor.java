package club.csiqu.practice.past;

public class JumpFloor {

    private static int jumpFloor0(int target) {
        int a = 1, b = 2, c = 0;
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        for (int i = 2; i < target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int jumpFloor1(int target) {
        int count = 0;
        int temp = 0;
        for (int i = 1; i <= target; i++) {
            count = count + temp;
            temp = count + 1;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor0(3));
        System.out.println(jumpFloor1(4));
    }
}