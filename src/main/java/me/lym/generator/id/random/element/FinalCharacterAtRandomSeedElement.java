package me.lym.generator.id.random.element;

public class FinalCharacterAtRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterAt = '@';

    public FinalCharacterAtRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterAt;
    }
}
