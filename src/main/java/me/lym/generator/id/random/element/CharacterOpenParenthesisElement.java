package me.lym.generator.id.random.element;

public class CharacterOpenParenthesisElement extends AbstractCharacterElement{

    public static final String characterOpenParenthesis = "(";

    public CharacterOpenParenthesisElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterOpenParenthesis;
    }
}
