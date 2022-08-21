package me.lym.generator.id.random;

import me.lym.generator.id.IdGenerator;
import me.lym.generator.id.random.element.CharacterElement;

import java.util.List;
import java.util.Random;

public class RandomIdGenerator implements IdGenerator {

    private RandomIdConfig randomIdConfig;

    public RandomIdGenerator(RandomIdConfig randomIdConfig) {
        this.randomIdConfig = randomIdConfig;
    }

    @Override
    public String next() {
        List<CharacterElement> characterElements = randomIdConfig.getCharacterElements();
        Random random = new Random();
        int length = 0;
        if (randomIdConfig.getMinLength().equals(randomIdConfig.getMaxLength())) {
            length = randomIdConfig.getMaxLength();
        }else {
            length = random.nextInt(randomIdConfig.getMaxLength() - randomIdConfig.getMinLength()) + randomIdConfig.getMinLength();
        }
        int totalWeight = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < characterElements.size(); i++) {
            totalWeight += characterElements.get(i).getWeight();
        }
        for (int i = 0; i < length; i++) {
            int nextElementIndicator = random.nextInt(totalWeight);
            for (int j = 0; j < characterElements.size(); j++) {
                CharacterElement characterElement = characterElements.get(j);
                if (characterElement.getWeight() > nextElementIndicator) {
                    stringBuilder.append(characterElement.generate());
                    break;
                }
                nextElementIndicator-=characterElement.getWeight();
            }
        }
        return stringBuilder.toString();
    }
}
