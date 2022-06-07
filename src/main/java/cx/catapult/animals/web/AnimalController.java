package cx.catapult.animals.web;

import cx.catapult.animals.domain.AnimalType;
import cx.catapult.animals.domain.BaseAnimal;
import cx.catapult.animals.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/1/animals", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping(value = "", produces = "application/json")
    public @ResponseBody
    Collection<BaseAnimal> all() {
        return service.all();
    }
    
    @GetMapping(value = "/types")
    public @ResponseBody
    AnimalType[] allTypes() {
        return AnimalType.values();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    BaseAnimal get(@PathVariable String id) {
        return service.get(id);
    }
    
    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    Boolean 
    remove(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    BaseAnimal
    create(@RequestBody BaseAnimal animal) {
        return service.create(animal);
    }
    
    @GetMapping(value = "/query/{query}")
    public @ResponseBody
    Collection<BaseAnimal>
    filter(@PathVariable String query) {
        return service.filter(query);
    }
}
