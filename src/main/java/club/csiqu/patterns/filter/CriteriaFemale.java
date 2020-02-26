package club.csiqu.patterns.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 15:29
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("FEMALE".equalsIgnoreCase(person.getGender())) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}