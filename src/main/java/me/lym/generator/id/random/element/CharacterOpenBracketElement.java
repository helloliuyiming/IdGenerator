package me.lym.generator.id.random.element;

public class CharacterOpenBracketElement extends AbstractCharacterElement{

    public static final String characterOpenBracket = "[";

    public CharacterOpenBracketElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterOpenBracket;
    }
}
