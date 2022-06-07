package cx.catapult.animals.service;

import cx.catapult.animals.domain.Cat;
import cx.catapult.animals.domain.Mouse;
import cx.catapult.animals.domain.Bird;

import cx.catapult.animals.domain.BaseAnimal;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AnimalService extends BaseService<BaseAnimal> {

    @PostConstruct
    public void initialize() {
        this.create(new Cat("Black", "Friend of Jerry", "Tom"));
        this.create(new Cat("Yellow", "Bili", "Furry cat"));
        this.create(new Cat("Grey", "Smelly", "Cat with friends"));
        this.create(new Cat("Orange", "Tiger", "Large cat"));
        this.create(new Cat("Orange", "Tigger", "Not a scary cat"));
        this.create(new Cat("Orange", "Garfield", "Lazy cat"));
        this.create(new Mouse("Brown", "Not really a cat", "Jerry"));
        this.create(new Bird("Black", "A smart bird", "Crow"));
        this.create(new Bird("Black and white", "A not so smart bird", "Ostrich"));
    }

}
