package club.csiqu.practice.past;

public class NumberOf1Between1AndN {

    private static int numberOf1Between1AndNSolution(int n) {
        int sum = 0;
        String str;
        for (int i = 1; i <= n; i++) {
            str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndNSolution(10000));
    }
}