package me.lym.generator.id.random.element;

public abstract class AbstractCharacterElement implements CharacterElement{

    private Integer weight;
    public AbstractCharacterElement(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
