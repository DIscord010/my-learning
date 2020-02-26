package club.csiqu.patterns.builder;

/**
 * 建造类，创建各类套餐
 *
 * @author chensiqu
 * @since 2019/3/19 10:31
 */
class MealBuilder {

    Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}