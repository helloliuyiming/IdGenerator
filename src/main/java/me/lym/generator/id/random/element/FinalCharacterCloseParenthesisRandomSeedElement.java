package me.lym.generator.id.random.element;

public class FinalCharacterCloseParenthesisRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterCloseParenthesis = ')';

    public FinalCharacterCloseParenthesisRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterCloseParenthesis;
    }
}
