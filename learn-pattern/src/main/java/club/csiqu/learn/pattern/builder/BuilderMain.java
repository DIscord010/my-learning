package club.csiqu.learn.pattern.builder;

/**
 * 建造者模式
 * <p>
 * 使用多个简单的对象一步一步构建成一个复杂的对象，
 * 就是将不同的对象组合在一起，
 * 适用于基本部件不变，但是组合经常变化的时候，
 * 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
 *
 * @author chensiqu
 * @since 2019/3/19 10:32
 */
public class BuilderMain {

    public static void main(String[] args) {
        // 创建套餐建造者对象
        MealBuilder mealBuilder = new MealBuilder();
        // 获取蔬菜套餐餐对象
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        // 获取无蔬菜套餐对象
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}