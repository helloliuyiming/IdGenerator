package me.lym.generator.id.random.element;

public class FinalCharacterOpenParenthesisRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterOpenParenthesis = '(';

    public FinalCharacterOpenParenthesisRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterOpenParenthesis;
    }
}
