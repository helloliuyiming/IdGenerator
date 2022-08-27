package me.lym.generator.id.random.element;

public class FinalCharacterExclamationRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterExclamation = '!';

    public FinalCharacterExclamationRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterExclamation;
    }
}
