package me.lym.generator.id.random.element;

public class CharacterSemicolonElement extends AbstractCharacterElement{

    public static final String characterSemicolon = ";";

    public CharacterSemicolonElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterSemicolon;
    }
}
