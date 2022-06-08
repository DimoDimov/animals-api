package cx.catapult.animals.service;

import cx.catapult.animals.domain.Animal;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseService<T extends Animal> implements Service<T> {

    private HashMap<String, T> items = new HashMap<>();

    @Override
    public Collection<T> all() {
        return items.values();
    }

    @Override
    public T create(T animal) {
        String id = UUID.randomUUID().toString();
        animal.setId(id);
        items.put(id, animal);
        return animal;
    }

    @Override
    public T get(String id) {
        return items.get(id);
    }

    @Override
    public Boolean deleteById(String id) {
        items.remove(id);
        return true;
    }
    
    @Override
    public Collection<T> filter(String query) {
        String queryLowered = query.toLowerCase();
        return items.values().stream()
                .filter(i -> i.getDescription().toLowerCase().contains(queryLowered)
                        || i.getName().toLowerCase().contains(queryLowered)
                        || i.getColour().toLowerCase().contains(queryLowered)
                        || i.getType().toString().toLowerCase().contains(queryLowered)
                        ).collect(Collectors.toList());
    }

}
