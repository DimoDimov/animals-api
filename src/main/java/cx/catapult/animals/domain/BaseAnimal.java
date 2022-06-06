package cx.catapult.animals.domain;

import java.io.Serializable;

public class BaseAnimal implements Animal, Serializable {

    private String id;
    private String colour;
    private String description;
    private AnimalType type;
    private String name;

    public BaseAnimal() {
        this("", "", "", "", AnimalType.MAMMALS);
    }

    public BaseAnimal(String colour, String description, String name, AnimalType type) {
        this(null, colour, description, name, type);
    }

    public BaseAnimal(String id, String colour, String description, String name, AnimalType type) {
        this.id = id;
        this.colour = colour;
        this.description = description;
        this.type = type;
        this.name = name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public AnimalType getType() {
        return this.type;
    }

    @Override
    public void setType(AnimalType type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
