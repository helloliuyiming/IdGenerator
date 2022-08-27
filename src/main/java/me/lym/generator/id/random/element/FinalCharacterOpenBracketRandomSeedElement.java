package me.lym.generator.id.random.element;

public class FinalCharacterOpenBracketRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterOpenBracket = '[';

    public FinalCharacterOpenBracketRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterOpenBracket;
    }
}
