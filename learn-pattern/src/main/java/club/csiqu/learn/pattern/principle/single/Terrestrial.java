package club.csiqu.learn.pattern.principle.single;

/**
 * @author chensiqu
 * @since 2019/3/13 13:52
 */
class Terrestrial extends AbstractAnimal {

    private String terrestrial;

    Terrestrial(String animal) {
        super(animal);
        this.terrestrial = animal;
    }

    @Override
    public void breathe() {
        System.out.println(terrestrial + "呼吸空气");
    }
}