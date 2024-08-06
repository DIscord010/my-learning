package club.csiqu.learn.tool.apache.http;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Siqu Chen 2024/2/28
 * @since 1.0.0
 */
public class CodecMain {

    public static void main(String[] args) {
        String symbol = "|";
        long timestamp = System.currentTimeMillis();
        String replace = "a8d24216040947488ac8691492fb575f";
        String digest = DigestUtils.md5Hex(replace + timestamp + "1C4D501F3C0F451492F55FE1C7D35F39").toUpperCase();
        String signature = replace + symbol + timestamp + symbol + digest;

        System.out.printf(signature);
    }
}