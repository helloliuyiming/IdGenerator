package me.lym.generator.id.random;

import me.lym.generator.id.random.element.CharacterElement;

import java.util.List;

public class RandomIdGeneratorBuilder {

    private RandomIdConfig randomIdConfig;

    public RandomIdGeneratorBuilder(){
        randomIdConfig = new RandomIdConfig();
    }

    public RandomIdGeneratorBuilder addCharacterElement(CharacterElement characterElement) {
        randomIdConfig.addCharacterElement(characterElement);
        return this;
    }

    public RandomIdGeneratorBuilder addAllCharacterElement(List<CharacterElement> characterElements) {
        randomIdConfig.addAllCharacterElement(characterElements);
        return this;
    }

    public RandomIdGeneratorBuilder insertCharacterElement(int index,CharacterElement characterElement) {
        randomIdConfig.insertCharacterElement(index, characterElement);
        return this;
    }

    public RandomIdGeneratorBuilder replaceCharacterElement(CharacterElement oldCharacterElement, CharacterElement newCharacterElement) {
        randomIdConfig.replaceCharacterElement(oldCharacterElement, newCharacterElement);
        return this;
    }

    public RandomIdGeneratorBuilder removeCharacterElement(CharacterElement characterElement) {
        randomIdConfig.removeCharacterElement(characterElement);
        return this;
    }

    public RandomIdGeneratorBuilder removeAllCharacterElement() {
        randomIdConfig.removeAllCharacterElement();
        return this;
    }
    public RandomIdGenerator build(){
        return new RandomIdGenerator(randomIdConfig);
    }
}
