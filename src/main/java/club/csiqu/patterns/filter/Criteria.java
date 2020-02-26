package club.csiqu.patterns.filter;

import java.util.List;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 15:26
 */
public interface Criteria {

    List<Person> meetCriteria(List<Person> persons);

}