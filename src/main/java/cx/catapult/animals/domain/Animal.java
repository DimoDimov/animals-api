package cx.catapult.animals.domain;

public interface Animal {

    String getId();

    void setId(String id);

    String getColour();

    void setColour(String colour);

    String getDescription();

    void setDescription(String description);

    AnimalType getType();
    
    void setType(AnimalType type);

    String getName();

    void setName(String name);
}
