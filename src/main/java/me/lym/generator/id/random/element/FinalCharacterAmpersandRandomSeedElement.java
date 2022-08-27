package me.lym.generator.id.random.element;

public class FinalCharacterAmpersandRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterAmpersand = '&';

    public FinalCharacterAmpersandRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterAmpersand;
    }
}
