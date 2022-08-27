package me.lym.generator.id.random.element;

public abstract class AbstractRandomSeedElement implements RandomSeedElement {

    private Integer weight;
    public AbstractRandomSeedElement(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
