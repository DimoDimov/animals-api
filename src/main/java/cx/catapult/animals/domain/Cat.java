package cx.catapult.animals.domain;

public class Cat extends BaseAnimal {
    public Cat() {
        this("", "", "");
    }

    public Cat(String colour, String description, String name) {
        super(colour, description, name, AnimalType.MAMMALS);
    }
}
