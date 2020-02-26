package club.csiqu.patterns.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式（标准模式）。
 * <p>
 * 创建一个标准接口，这个接口的实现类指定了不同的标准，
 * 使用这些实现类来过滤指定的对象集。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 15:40
 */
public class CriteriaMain {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    private static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}