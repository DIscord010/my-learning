package club.csiqu.patterns.principle.single;

/**
 * @author chensiqu
 * @since 2019/3/13 13:52
 */
abstract class AbstractAnimal {

    private String animal;

    AbstractAnimal(String animal) {
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

    public abstract void breathe();
}