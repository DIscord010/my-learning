package club.csiqu.practice.past;

public class BinaryNumber {

    public int numberOf1(int n) {
        String string = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}