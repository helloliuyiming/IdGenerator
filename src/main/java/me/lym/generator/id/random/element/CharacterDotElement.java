package me.lym.generator.id.random.element;

public class CharacterDotElement extends AbstractCharacterElement{

    public static final String characterDot = ".";

    public CharacterDotElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterDot;
    }
}
