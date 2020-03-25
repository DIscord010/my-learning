package club.csiqu.learn.pattern.principle.single;

/**
 * 单一原则
 * <p>
 * 通俗的说，即一个类只负责一项职责。指责扩散之时尽量进行重构。
 *
 * @author chensiqu
 * @since 2019/3/12 17:34
 */
public class Main {

    public static void main(String[] args) {
        AbstractAnimal cow = new Terrestrial("牛");
        AbstractAnimal sheep = new Terrestrial("羊");
        AbstractAnimal pig = new Terrestrial("猪");
        AbstractAnimal fish = new Aquaitc("鲨鱼");
        cow.breathe();
        sheep.breathe();
        pig.breathe();
        fish.breathe();
    }
}