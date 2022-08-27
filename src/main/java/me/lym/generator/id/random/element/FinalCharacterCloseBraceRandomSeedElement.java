package me.lym.generator.id.random.element;

public class FinalCharacterCloseBraceRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterCloseBrace = '}';

    public FinalCharacterCloseBraceRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterCloseBrace;
    }
}
