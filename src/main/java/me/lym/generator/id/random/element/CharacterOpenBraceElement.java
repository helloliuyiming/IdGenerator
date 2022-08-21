package me.lym.generator.id.random.element;

public class CharacterOpenBraceElement extends AbstractCharacterElement{

    public static final String characterOpenBrace = "{";

    public CharacterOpenBraceElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterOpenBrace;
    }
}
