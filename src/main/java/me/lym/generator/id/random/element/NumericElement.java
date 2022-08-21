package me.lym.generator.id.random.element;

import java.util.Random;

public class NumericElement extends AbstractCharacterElement{

    Random random = new Random();

    public NumericElement(Integer weight) {
        super(weight);
    }

    @Override
    public String generate() {
        return String.valueOf(random.nextInt(10));
    }
}
