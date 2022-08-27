package me.lym.generator.id.random.element;

public class FinalCharacterUnderlineRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterUnderline = '_';

    public FinalCharacterUnderlineRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterUnderline;
    }
}
