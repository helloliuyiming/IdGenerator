package me.lym.generator.id.random.element;

public class CharacterColonElement extends AbstractCharacterElement{

    public static final String characterColon = ":";

    public CharacterColonElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterColon;
    }
}
