package me.lym.generator.id.random.element;

public class FinalCharacterOpenBraceRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterOpenBrace = '{';

    public FinalCharacterOpenBraceRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterOpenBrace;
    }
}
