package me.lym.generator.id.random.element;

public class CharacterHyphenElement extends AbstractCharacterElement{

    public static final String characterHyphen = "-";

    public CharacterHyphenElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterHyphen;
    }
}
