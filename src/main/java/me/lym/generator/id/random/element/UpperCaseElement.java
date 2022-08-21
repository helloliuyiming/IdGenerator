package me.lym.generator.id.random.element;

import java.util.Random;

public class UpperCaseElement extends AbstractCharacterElement{

    Random random = new Random();

    public UpperCaseElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        int randomInt = random.nextInt(26) + 65;
        char c = (char) randomInt;
        return String.valueOf(c);
    }

}
