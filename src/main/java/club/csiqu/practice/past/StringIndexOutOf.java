package club.csiqu.practice.past;

public class StringIndexOutOf {

    private static void test(String[] args) {
        System.out.println("字符串索引越界异常");
        String str = args[0];
        try {
            System.out.println("第四个字符为" + str.charAt(3));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("字符串索引越界");
        }
        try {
            int a = Integer.parseInt(args[0]);
            System.out.println("平方为" + a * a);
        } catch (NumberFormatException e) {
            System.out.println("数字格式化错误");
        }
    }

    public static void main(String[] args) {
        test(new String[]{"abc"});
    }
}