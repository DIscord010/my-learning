package club.csiqu.learn.pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqu
 * @since 2019/3/19 10:19
 */
class Meal {

    private List<AbstractItem> items = new ArrayList<>();

    void addItem(AbstractItem item) {
        items.add(item);
    }

    float getCost() {
        float cost = 0.0f;
        for (AbstractItem item : items) {
            cost += item.price();
        }
        return cost;
    }

    void showItems() {
        items.forEach((item) -> {
            System.out.print("AbstractItem : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        });
    }
}