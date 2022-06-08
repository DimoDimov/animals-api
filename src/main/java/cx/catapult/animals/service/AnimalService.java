package cx.catapult.animals.service;

import cx.catapult.animals.domain.AnimalType;
import cx.catapult.animals.domain.BaseAnimal;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AnimalService extends BaseService<BaseAnimal> {

    @PostConstruct
    public void initialize() {
        this.create(new BaseAnimal("Black", "Friend of Jerry", "Tom", AnimalType.MAMMALS));
        this.create(new BaseAnimal("Yellow", "Bili", "Furry cat", AnimalType.MAMMALS));
        this.create(new BaseAnimal("Grey", "Smelly", "Cat with friends", AnimalType.MAMMALS));
        this.create(new BaseAnimal("Orange", "Tiger", "Large cat", AnimalType.MAMMALS));
        this.create(new BaseAnimal("Orange", "Tigger", "Not a scary cat", AnimalType.MAMMALS));
        this.create(new BaseAnimal("Orange", "Garfield", "Lazy cat", AnimalType.MAMMALS));
        this.create(new BaseAnimal("Brown", "Not really a cat", "Jerry", AnimalType.MAMMALS));
        this.create(new BaseAnimal("Black", "A smart bird", "Crow", AnimalType.BIRD));
        this.create(new BaseAnimal("Black and white", "A not so smart bird", "Ostrich", AnimalType.BIRD));
    }

}
