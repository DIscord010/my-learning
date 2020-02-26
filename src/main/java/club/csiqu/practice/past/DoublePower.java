package club.csiqu.practice.past;

public class DoublePower {

    private static double power(double base, int exponent) {
        double count = base;
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            for (int i = 1; i < exponent; i++) {
                count = base * count;
            }
        } else {
            for (int i = 1; i < Math.abs(exponent); i++) {
                count = base * count;
            }
            return 1 / count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(power(2, -3));
    }
}