package club.csiqu.learn.basis;

/**
 * @author Siqu Chen 2020/11/20
 * @since 1.0.0
 */
public class SwitchString {

    public static String switchString(String param) {
        switch (param) {
            case "string":
                return "string";
            case "null":
                return "null";
            default:
                return "default";
        }
    }
}