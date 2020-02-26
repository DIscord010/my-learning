package club.csiqu.patterns.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 15:37
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("SINGLE".equalsIgnoreCase(person.getMaritalStatus())) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}