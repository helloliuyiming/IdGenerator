package me.lym.generator.id.random.element;

public class FinalCharacterHyphenRandomSeedElement extends AbstractRandomSeedElement {

    public static final char characterHyphen = '-';

    public FinalCharacterHyphenRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        return characterHyphen;
    }
}
