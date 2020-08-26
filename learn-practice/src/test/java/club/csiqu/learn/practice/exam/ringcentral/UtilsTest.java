package club.csiqu.learn.practice.exam.ringcentral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siqu Chen 2020/8/25
 * @since 1.0
 */
class UtilsTest {

    @Test
    void testSortByName() {
    }

    @Test
    void testSortByExtType() {
        List<Extension> list = new ArrayList<>(4);
        Extension extension0 = new Extension();
        extension0.setExtType("AO");
        Extension extension1 = new Extension();
        extension1.setExtType("Dept");
        list.add(extension0);
        list.add(extension1);
        Assertions.assertEquals(extension1, Utils.sortByExtType(list).get(0));
    }

    @Test
    void testSumByQuarter() {
        List<SaleItem> saleItems = new ArrayList<>(4);
        SaleItem saleItem0 = new SaleItem();
        saleItem0.setMonth(1);
        saleItem0.setSaleNumbers(5.0);
        SaleItem saleItem1 = new SaleItem();
        saleItem1.setMonth(2);
        saleItem1.setSaleNumbers(5.0);
        SaleItem saleItem2 = new SaleItem();
        saleItem2.setMonth(3);
        saleItem2.setSaleNumbers(5.0);
        SaleItem saleItem3 = new SaleItem();
        saleItem3.setMonth(4);
        saleItem3.setSaleNumbers(5.0);
        saleItems.add(saleItem0);
        saleItems.add(saleItem1);
        saleItems.add(saleItem2);
        saleItems.add(saleItem3);
        Assertions.assertEquals(15.0, Utils.sumByQuarter(saleItems).get(0).getValue());
    }

    @Test
    void testMaxByQuarter() {
        List<SaleItem> saleItems = new ArrayList<>(4);
        SaleItem saleItem0 = new SaleItem();
        saleItem0.setMonth(1);
        saleItem0.setSaleNumbers(5.0);
        SaleItem saleItem1 = new SaleItem();
        saleItem1.setMonth(2);
        saleItem1.setSaleNumbers(7.0);
        SaleItem saleItem2 = new SaleItem();
        saleItem2.setMonth(3);
        saleItem2.setSaleNumbers(20.0);
        saleItems.add(saleItem0);
        saleItems.add(saleItem1);
        saleItems.add(saleItem2);
        Assertions.assertEquals(20.0, Utils.maxByQuarter(saleItems).get(0).getValue());
    }

    @Test
    void testGetUnUsedKeys() {
        int[] allKeys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] useKeys = {2, 3, 4};
        Assertions.assertArrayEquals(new int[]{0, 1, 5, 6, 7, 8, 9}, Utils.getUnUsedKeys(allKeys, useKeys));
    }
}