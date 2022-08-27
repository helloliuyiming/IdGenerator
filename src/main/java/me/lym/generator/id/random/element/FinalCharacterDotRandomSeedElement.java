package me.lym.generator.id.random.element;

public class FinalCharacterDotRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterDot = '.';

    public FinalCharacterDotRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterDot;
    }
}
