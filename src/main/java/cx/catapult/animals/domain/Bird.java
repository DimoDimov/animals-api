package cx.catapult.animals.domain;

public class Bird extends BaseAnimal {
    public Bird() {
        this("", "", "");
    }
    
    public Bird(String colour, String description, String name) {
        super(colour, description, name, AnimalType.BIRD);
    }
}
