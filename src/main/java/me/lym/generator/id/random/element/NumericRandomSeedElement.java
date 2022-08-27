package me.lym.generator.id.random.element;

import java.util.Random;

public class NumericRandomSeedElement extends AbstractRandomSeedElement {

    private final Random random = new Random();

    public NumericRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        int randomInt = random.nextInt(10) + 48;
        return (char) randomInt;
    }
}
