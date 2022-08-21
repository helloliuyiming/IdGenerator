package me.lym.generator.id.random.element;

public class CharacterExclamationElement extends AbstractCharacterElement{

    public static final String characterExclamation = "!";

    public CharacterExclamationElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return characterExclamation;
    }
}
