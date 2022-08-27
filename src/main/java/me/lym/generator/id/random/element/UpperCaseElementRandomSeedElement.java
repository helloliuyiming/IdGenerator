package me.lym.generator.id.random.element;

import java.util.Random;

public class UpperCaseElementRandomSeedElement extends AbstractRandomSeedElement {

    private final Random random = new Random();

    public UpperCaseElementRandomSeedElement(Integer weight) {
        super(weight);
    }

    @Override
    public char generate() {
        int randomInt = random.nextInt(26) + 65;
         return (char) randomInt;
    }

}
