package me.lym.generator.id.random.element;

public class CharacterAsteriskElement extends AbstractCharacterElement{

    public static final String characterAsterisk = "*";

    public CharacterAsteriskElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterAsterisk;
    }
}
