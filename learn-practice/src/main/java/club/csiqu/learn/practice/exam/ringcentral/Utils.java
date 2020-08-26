package club.csiqu.learn.practice.exam.ringcentral;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Siqu Chen 2020/8/25
 * @since 1.0
 */
public class Utils {

    private Utils() {}

    /**
     * Question1, sort by firstName + lastName + ext,
     * if firstName is the same then sort by lastName and
     * ext, please note lastName and ext can be empty
     * string or null.
     **/
    public static List<Extension> sortByName(List<Extension> extensions) {
        return null;
    }

    /**
     * Question2, sort extType, extType is a string and can
     * be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     **/
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        if (extensions.size() <= 1) {
            return extensions;
        }
        HashMap<String, Integer> extTypes = new HashMap<>(8);
        extTypes.put("User", 5);
        extTypes.put("Dept", 4);
        extTypes.put("AO", 3);
        extTypes.put("TMO", 2);
        extTypes.put("Other", 1);
        return extensions.stream().sorted(
                (a, b) -> {
                    String extType1 = a.getExtType();
                    String extType2 = b.getExtType();
                    // big -> small
                    return extTypes.get(extType2) - extTypes.get(extType1);
                }
        ).collect(Collectors.toList());
    }

    /**
     * Question3, sum all sales items by quarter
     **/
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
        return saleItems.stream()
                .collect(Collectors.groupingBy(s -> (s.getMonth() - 1) / 3 + 1,
                        Collectors.summingDouble(SaleItem::getSaleNumbers)))
                .entrySet().stream().map(
                        e -> {
                            QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
                            quarterSalesItem.setQuarter(e.getKey());
                            quarterSalesItem.setValue(e.getValue());
                            return quarterSalesItem;
                        }).collect(Collectors.toList());
    }

    /**
     * Question4, max all sales items by quarter
     **/
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        return saleItems.stream()
                .collect(Collectors.groupingBy(s -> (s.getMonth() - 1) / 3 + 1,
                        Collectors.maxBy(Comparator.comparing(SaleItem::getSaleNumbers))))
                .entrySet().stream().map(
                        e -> {
                            QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
                            quarterSalesItem.setQuarter(e.getKey());
                            quarterSalesItem.setValue(e.getValue().get().getSaleNumbers());
                            return quarterSalesItem;
                        }).collect(Collectors.toList());
    }

    /**
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :
     * [2,3,4];
     * We want to get all unused keys, in this example it
     * would be: [0,1,5,6,7,8,9,]
     */
    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        for (int i : usedKeys) {
            allKeys[i] = -1;
        }
        int[] result = new int[allKeys.length - usedKeys.length];
        int i = 0;
        for (int j : allKeys) {
            if (j != -1) {
                result[i++] = j;
            }
        }
        return result;
    }
}