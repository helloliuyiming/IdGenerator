package me.lym.generator.id.random.element;

public class CharacterCommaElement extends AbstractCharacterElement{

    public static final String characterComma = ",";

    public CharacterCommaElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterComma;
    }
}
