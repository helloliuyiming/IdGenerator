package me.lym.generator.id.random.element;

public class CharacterCloseParenthesisElement extends AbstractCharacterElement{

    public static final String characterCloseParenthesis = ")";

    public CharacterCloseParenthesisElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterCloseParenthesis;
    }
}
