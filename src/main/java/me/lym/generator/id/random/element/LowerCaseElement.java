package me.lym.generator.id.random.element;

import java.util.Random;

public class LowerCaseElement extends AbstractCharacterElement{

    Random random = new Random();

    public LowerCaseElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        int randomInt = random.nextInt(26) + 97;
        char c = (char) randomInt;
        return String.valueOf(c);
    }

}
