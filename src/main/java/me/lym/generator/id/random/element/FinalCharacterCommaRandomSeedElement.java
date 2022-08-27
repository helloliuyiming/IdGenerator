package me.lym.generator.id.random.element;

public class FinalCharacterCommaRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterComma = ',';

    public FinalCharacterCommaRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterComma;
    }
}
