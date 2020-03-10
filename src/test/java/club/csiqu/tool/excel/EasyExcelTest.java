package club.csiqu.tool.excel;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class EasyExcelTest {

    @Test
    public void simpleRead() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("./src/main/resources/file/excel/easyExcel.xls");
        EasyExcel.read(inputStream, DemoData.class, new DemoDataListener()).sheet().doRead();
    }
}