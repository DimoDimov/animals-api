package cx.catapult.animals.web;

import cx.catapult.animals.domain.Animal;
import cx.catapult.animals.domain.AnimalType;
import cx.catapult.animals.domain.BaseAnimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AnimalControllerIT {
    @LocalServerPort
    private int port;

    private URL base;

    private BaseAnimal cat = new BaseAnimal("Brown", "Tom", "Bob cat", AnimalType.MAMMALS);

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/api/1/animals");
    }

    @Test
    public void createShouldWork() throws Exception {
        ResponseEntity<BaseAnimal> response = template.postForEntity(base.toString(), cat, BaseAnimal.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isNotEmpty();
        assertThat(response.getBody().getName()).isEqualTo(cat.getName());
        assertThat(response.getBody().getDescription()).isEqualTo(cat.getDescription());
        assertThat(response.getBody().getType()).isEqualTo(cat.getType());
    }

    @Test
    public void allShouldWork() throws Exception {
        Collection items = template.getForObject(base.toString(), Collection.class);
        assertThat(items.size()).isGreaterThanOrEqualTo(7);
    }

    @Test
    public void getShouldWork() throws Exception {
        BaseAnimal created = createCat("Test 1");
        ResponseEntity<String> response = template.getForEntity(base.toString() + "/" + created.getId(), String.class);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public void deleteShouldWork() throws Exception {
        BaseAnimal created = createCat("Test 1");
        ResponseEntity<String> responseGet = template.getForEntity(base.toString() + "/" + created.getId(),
                String.class);
        assertThat(responseGet.getBody()).isNotEmpty();

        template.delete(base.toString() + "/" + created.getId());

        ResponseEntity<String> responseGetAfterDelete = template.getForEntity(base.toString() + "/" + created.getId(),
                String.class);
        assertThat(responseGetAfterDelete.getBody()).isEmpty();
    }
    
    @Test
    public void filterShouldWork() throws Exception {
        BaseAnimal created = new BaseAnimal("uniqueName", "uniqueColour", "uniqueDesc", AnimalType.AMPHIBIAN);
        ResponseEntity<String> responseGet = template.getForEntity(base.toString() + "/" + created.getId(), String.class);
        assertThat(responseGet.getBody()).isNotEmpty();
        
        Collection itemsGetColour = template.getForObject(base.toString() + "/query/" + created.getColour(),
                Collection.class);
        assertThat(itemsGetColour.size()).isEqualTo(1);
        
        Collection itemsGetName = template.getForObject(base.toString() + "/query/" + created.getName(), Collection.class);
        assertThat(itemsGetName.size()).isEqualTo(1);
        
        Collection itemsGetType = template.getForObject(base.toString() + "/query/" + created.getType().toString(), Collection.class);
        assertThat(itemsGetType.size()).isEqualTo(1);
        
        Collection itemsGetDescription = template.getForObject(base.toString() + "/query/" + created.getDescription(), Collection.class);
        assertThat(itemsGetDescription.size()).isEqualTo(1);
        
        Collection itemsGetNonExisting = template.getForObject(base.toString() + "/query/somethingelse", Collection.class);
        assertThat(itemsGetNonExisting.size()).isEqualTo(0);
    }

    BaseAnimal createCat(String name) {
        BaseAnimal created = template.postForObject(base.toString(), new BaseAnimal(name, name, name, AnimalType.MAMMALS), BaseAnimal.class);
        assertThat(created.getId()).isNotEmpty();
        assertThat(created.getName()).isEqualTo(name);
        return created;
    }
}
