package me.lym.generator.id.random.element;

public class CharacterAmpersandElement extends AbstractCharacterElement{

    public static final String characterAmpersand = "&";

    public CharacterAmpersandElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterAmpersand;
    }
}
