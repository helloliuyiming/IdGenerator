package me.lym.generator.id.random.element;

public class CharacterUnderlineElement extends AbstractCharacterElement{

    public static final String characterUnderline = "_";

    public CharacterUnderlineElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterUnderline;
    }
}
