package me.lym.generator.id.random.element;

public class FinalCharacterSpaceRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterSpace = ' ';

    public FinalCharacterSpaceRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterSpace;
    }
}
