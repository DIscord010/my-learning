package club.csiqu.learn.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 15:27
 */
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("MALE".equalsIgnoreCase(person.getGender())) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}