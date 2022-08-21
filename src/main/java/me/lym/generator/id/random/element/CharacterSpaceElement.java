package me.lym.generator.id.random.element;

public class CharacterSpaceElement extends AbstractCharacterElement{

    public static final String characterSpace = " ";

    public CharacterSpaceElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterSpace;
    }
}
