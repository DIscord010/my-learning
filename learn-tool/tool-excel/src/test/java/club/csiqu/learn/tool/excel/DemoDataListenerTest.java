package club.csiqu.learn.tool.excel;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siqu Chen 2020/3/25
 * @since 1.0.0
 */
class DemoDataListenerTest {

    @Test
    public void simpleRead() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("./src/test/resources/file/excel/easyExcel.xls");
        DemoDataListener demoDataListener = new DemoDataListener();
        EasyExcel.read(inputStream, DemoData.class, demoDataListener).sheet().doRead();
        assertEquals(1,demoDataListener.list.size());
    }
}