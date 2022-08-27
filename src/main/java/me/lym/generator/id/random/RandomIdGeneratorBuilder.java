package me.lym.generator.id.random;

import me.lym.generator.id.random.element.RandomSeedElement;

import java.util.List;

public class RandomIdGeneratorBuilder {

    private RandomIdConfig randomIdConfig;

    public RandomIdGeneratorBuilder(){
        randomIdConfig = new RandomIdConfig();
    }

    public RandomIdGeneratorBuilder addCharacterElement(RandomSeedElement randomSeedElement) {
        randomIdConfig.addCharacterElement(randomSeedElement);
        return this;
    }

    public RandomIdGeneratorBuilder addCharacterElements(List<RandomSeedElement> randomSeedElements) {
        randomIdConfig.addAllCharacterElement(randomSeedElements);
        return this;
    }

    public RandomIdGeneratorBuilder insertCharacterElement(int index, RandomSeedElement randomSeedElement) {
        randomIdConfig.insertCharacterElement(index, randomSeedElement);
        return this;
    }

    public RandomIdGeneratorBuilder replaceCharacterElement(RandomSeedElement oldRandomSeedElement, RandomSeedElement newRandomSeedElement) {
        randomIdConfig.replaceCharacterElement(oldRandomSeedElement, newRandomSeedElement);
        return this;
    }

    public RandomIdGeneratorBuilder removeCharacterElement(RandomSeedElement randomSeedElement) {
        randomIdConfig.removeCharacterElement(randomSeedElement);
        return this;
    }

    public RandomIdGeneratorBuilder removeAllCharacterElement() {
        randomIdConfig.removeAllCharacterElement();
        return this;
    }

    public RandomIdGeneratorBuilder setMaxLength(int maxLength) {
        if (maxLength < 1) {
            throw new IllegalArgumentException("maxLength must be positive");
        }
        randomIdConfig.setMaxLength(maxLength);
        return this;
    }

    public RandomIdGeneratorBuilder setMinLength(int minLength) {
        if (minLength < 1) {
            throw new IllegalArgumentException("minLength must be positive");
        }
        randomIdConfig.setMinLength(minLength);
        return this;
    }
    public RandomIdGenerator build(){
        if (randomIdConfig.getMaxLength() < randomIdConfig.getMinLength()) {
            throw new IllegalArgumentException("maxLength can't be less than minLength and now minLength = " + randomIdConfig.getMinLength() + ", maxLength = " + randomIdConfig.getMaxLength());
        }
        return new RandomIdGenerator(randomIdConfig);
    }
}
