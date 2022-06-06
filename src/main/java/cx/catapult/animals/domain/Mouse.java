package cx.catapult.animals.domain;

public class Mouse extends BaseAnimal {
  public Mouse() {
    this("", "", "");
  }  
  
  public Mouse(String colour, String description, String name) {
        super(colour, description, name, AnimalType.MAMMALS);
    }
}
