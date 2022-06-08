package cx.catapult.animals.service;

import cx.catapult.animals.domain.AnimalType;
import cx.catapult.animals.domain.BaseAnimal;

import org.junit.jupiter.api.Test;
import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;

public class AnimalServiceTest {

    AnimalService service = new AnimalService();
    BaseAnimal cat = new BaseAnimal("Brown", "Tom", "Bob cat", AnimalType.MAMMALS);

    @Test
    public void createShouldWorkForAnimal() throws Exception {
        BaseAnimal thisMouse = new BaseAnimal();
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

    @Test
    public void filterShouldWork() throws Exception {
        BaseAnimal amazingAnimal = new BaseAnimal("Blue", "great animal", "Amazing Animal", AnimalType.MAMMALS);
        service.create(amazingAnimal);
        BaseAnimal actual = service.get(amazingAnimal.getId());
        assertThat(actual).isEqualTo(amazingAnimal);
        Collection<BaseAnimal> result = service.filter(amazingAnimal.getName());
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void deleteShouldWork() throws Exception {
        BaseAnimal deletionAnimal = new BaseAnimal("Blue", "animal to delete", "Deleted Animal", AnimalType.MAMMALS);
        service.create(deletionAnimal);
        BaseAnimal actual = service.get(deletionAnimal.getId());
        assertThat(actual).isEqualTo(deletionAnimal);
        Collection<BaseAnimal> filteredResult = service.filter(deletionAnimal.getName());
        assertThat(filteredResult.size()).isEqualTo(1);

        Boolean deletionResult = service.deleteById(deletionAnimal.getId());
        assertThat(deletionResult).isEqualTo(true);

        Collection<BaseAnimal> filteredResultPostDeletion = service.filter(deletionAnimal.getName());
        assertThat(filteredResultPostDeletion.size()).isEqualTo(0);
    }
}
