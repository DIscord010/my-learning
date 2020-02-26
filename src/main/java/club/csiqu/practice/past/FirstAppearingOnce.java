package club.csiqu.practice.past;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符
 *
 * @author chensiqu
 * @since 2019/3/13 17:45
 */
public class FirstAppearingOnce {

    private StringBuilder s = new StringBuilder();

    private int[] ints = new int[128];

    private void insert(char ch) {
        s.append(ch);
        ints[ch]++;
    }

    private char firstAppearingOnce() {
        for (int i = 0, length = s.length(); i < length; i++) {
            if (ints[s.charAt(i)] == 1) {
                return s.charAt(i);
            }

        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.insert('g');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
    }
}