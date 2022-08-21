package me.lym.generator.id.random.element;

public class CharacterCloseBracketElement extends AbstractCharacterElement{

    public static final String characterCloseBracket = "]";

    public CharacterCloseBracketElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterCloseBracket;
    }
}
