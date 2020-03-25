package club.csiqu.learn.pattern.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqu
 * @since 2019/3/13 13:51
 */
class CompanyManager {

    private List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Employee emp = new Employee();
            // 为总公司人员按顺序分配一个ID
            emp.setId("总公司" + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(SubCompanyManager sub) {
        // 修改后在SubCompanyManager类中增加了printEmployee()方法
        sub.printEmployee();
        List<Employee> list = this.getAllEmployee();
        for (Employee e : list) {
            System.out.println(e.getId());
        }
    }
}