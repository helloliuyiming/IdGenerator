package me.lym.generator.id.random.element;

public class CharacterAtElement extends AbstractCharacterElement{

    public static final String characterAt = "@";

    public CharacterAtElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterAt;
    }
}
