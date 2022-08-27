package me.lym.generator.id.random.element;

public class FinalCharacterColonRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterColon = ':';

    public FinalCharacterColonRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterColon;
    }
}
