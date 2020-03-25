package club.csiqu.learn.pattern.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqu
 * @since 2019/3/13 13:51
 */
class SubCompanyManager {

    private List<SubEmployee> getAllEmployee() {
        List<SubEmployee> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            SubEmployee emp = new SubEmployee();
            // 为分公司人员按顺序分配一个ID
            emp.setId("分公司" + i);
            list.add(emp);
        }
        return list;
    }

    void printEmployee() {
        List<SubEmployee> list = this.getAllEmployee();
        for (SubEmployee e : list) {
            System.out.println(e.getId());
        }
    }
}