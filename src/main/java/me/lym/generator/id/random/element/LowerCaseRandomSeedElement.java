package me.lym.generator.id.random.element;

import java.util.Random;

public class LowerCaseRandomSeedElement extends AbstractRandomSeedElement {

    private final Random random = new Random();

    public LowerCaseRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        int randomInt = random.nextInt(26) + 97;
        return (char) randomInt;
    }

}
