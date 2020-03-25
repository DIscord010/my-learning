package club.csiqu.learn.tool.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/18 16:14
 */
public class DemoData {

    @ExcelProperty(index = 0)
    private String first;

    @ExcelProperty(index = 1)
    private String second;

    @ExcelProperty(index = 2)
    private String third;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }
}