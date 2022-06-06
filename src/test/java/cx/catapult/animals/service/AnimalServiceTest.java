package cx.catapult.animals.service;

import cx.catapult.animals.domain.AnimalType;
import cx.catapult.animals.domain.BaseAnimal;
import cx.catapult.animals.domain.Bird;
import cx.catapult.animals.domain.Cat;
import cx.catapult.animals.domain.Mouse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalServiceTest {

    AnimalService service = new AnimalService();
    BaseAnimal cat = new Cat("Brown", "Tom", "Bob cat");

    @Test
    public void createShouldWorkForMouse() throws Exception {
        BaseAnimal thisMouse = new Mouse();
        thisMouse.setName("Jerry");
        thisMouse.setDescription("Mouse");
        thisMouse.setColour("Brown");
        thisMouse.setType(AnimalType.MAMMALS);
        BaseAnimal actual = service.create(thisMouse);
        assertThat(actual).isEqualTo(thisMouse);
        assertThat(actual.getName()).isEqualTo(thisMouse.getName());
        assertThat(actual.getDescription()).isEqualTo(thisMouse.getDescription());
        assertThat(actual.getType()).isEqualTo(thisMouse.getType());
    }

    @Test
    public void createShouldWorkForBird() throws Exception {
        BaseAnimal thisBird = new Bird();
        thisBird.setName("Crow");
        thisBird.setDescription("A smart bird");
        thisBird.setColour("Black");
        thisBird.setType(AnimalType.BIRD);
        BaseAnimal actual = service.create(thisBird);
        assertThat(actual).isEqualTo(thisBird);
        assertThat(actual.getName()).isEqualTo(thisBird.getName());
        assertThat(actual.getDescription()).isEqualTo(thisBird.getDescription());
        assertThat(actual.getType()).isEqualTo(thisBird.getType());
    }

    @Test
    public void createShouldWorkForCat() throws Exception {
        BaseAnimal thisCat = new Cat();
        thisCat.setName("Tom");
        thisCat.setDescription("The coolest cat");
        thisCat.setColour("Black");
        thisCat.setType(AnimalType.MAMMALS);
        BaseAnimal actual = service.create(thisCat);
        assertThat(actual).isEqualTo(thisCat);
        assertThat(actual.getName()).isEqualTo(thisCat.getName());
        assertThat(actual.getDescription()).isEqualTo(thisCat.getDescription());
        assertThat(actual.getType()).isEqualTo(thisCat.getType());
    }

    @Test
    public void allShouldWork() throws Exception {
        service.create(cat);
        assertThat(service.all().size()).isEqualTo(1);
    }

    @Test
    public void getShouldWork() throws Exception {
        service.create(cat);
        BaseAnimal actual = service.get(cat.getId());
        assertThat(actual).isEqualTo(cat);
        assertThat(actual.getName()).isEqualTo(cat.getName());
        assertThat(actual.getDescription()).isEqualTo(cat.getDescription());
        assertThat(actual.getType()).isEqualTo(cat.getType());
    }
}
