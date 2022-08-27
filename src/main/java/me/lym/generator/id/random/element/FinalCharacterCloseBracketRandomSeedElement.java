package me.lym.generator.id.random.element;

public class FinalCharacterCloseBracketRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterCloseBracket = ']';

    public FinalCharacterCloseBracketRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterCloseBracket;
    }
}
