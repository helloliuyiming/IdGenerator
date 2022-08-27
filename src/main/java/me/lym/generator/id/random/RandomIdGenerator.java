package me.lym.generator.id.random;

import me.lym.generator.id.IdGenerator;
import me.lym.generator.id.random.element.RandomSeedElement;

import java.util.List;
import java.util.Random;

public class RandomIdGenerator implements IdGenerator {

    private RandomIdConfig randomIdConfig;

    public RandomIdGenerator(RandomIdConfig randomIdConfig) {
        this.randomIdConfig = randomIdConfig;
    }

    @Override
    public String next() {
        List<RandomSeedElement> randomSeedElements = randomIdConfig.getCharacterElements();
        Random random = new Random();
        int length = 0;
        if (randomIdConfig.getMinLength().equals(randomIdConfig.getMaxLength())) {
            length = randomIdConfig.getMaxLength();
        }else {
            length = random.nextInt(randomIdConfig.getMaxLength() - randomIdConfig.getMinLength()) + randomIdConfig.getMinLength();
        }
        int totalWeight = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < randomSeedElements.size(); i++) {
            totalWeight += randomSeedElements.get(i).getWeight();
        }
        for (int i = 0; i < length; i++) {
            int nextElementIndicator = random.nextInt(totalWeight);
            for (int j = 0; j < randomSeedElements.size(); j++) {
                RandomSeedElement randomSeedElement = randomSeedElements.get(j);
                if (randomSeedElement.getWeight() > nextElementIndicator) {
                    stringBuilder.append(randomSeedElement.generate());
                    break;
                }
                nextElementIndicator-= randomSeedElement.getWeight();
            }
        }
        return stringBuilder.toString();
    }
}
