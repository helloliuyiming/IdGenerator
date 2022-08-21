package me.lym.generator.id.random.element;

public class CharacterCloseBraceElement extends AbstractCharacterElement{

    public static final String characterCloseBrace = "}";

    public CharacterCloseBraceElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterCloseBrace;
    }
}
