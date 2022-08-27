package me.lym.generator.id.random.element;

public class FinalCharacterAsteriskRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterAsterisk = '*';

    public FinalCharacterAsteriskRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterAsterisk;
    }
}
