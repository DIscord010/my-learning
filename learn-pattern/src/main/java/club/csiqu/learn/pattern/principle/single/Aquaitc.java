package club.csiqu.learn.pattern.principle.single;

/**
 * @author chensiqu
 * @since 2019/3/13 13:52
 */
class Aquaitc extends AbstractAnimal {

    private String aquaitc;

    Aquaitc(String animal) {
        super(animal);
        this.aquaitc = animal;
    }

    @Override
    public void breathe() {
        System.out.println(aquaitc + "呼吸水");
    }
}