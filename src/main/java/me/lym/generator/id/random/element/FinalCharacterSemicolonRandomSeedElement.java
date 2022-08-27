package me.lym.generator.id.random.element;

public class FinalCharacterSemicolonRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterSemicolon = ';';

    public FinalCharacterSemicolonRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterSemicolon;
    }
}
