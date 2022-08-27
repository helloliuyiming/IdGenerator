package me.lym.generator.id.random;

import me.lym.generator.id.random.element.RandomSeedElement;

import java.util.ArrayList;
import java.util.List;

public class RandomIdConfig {

    private Integer maxLength = 1;
    private Integer minLength = 1;
    private List<RandomSeedElement> randomSeedElements;

    public RandomIdConfig(){
        randomSeedElements = new ArrayList<>();
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public List<RandomSeedElement> getCharacterElements(){
        return this.randomSeedElements;
    }

    public RandomIdConfig addCharacterElement(RandomSeedElement randomSeedElement) {
        this.randomSeedElements.add(randomSeedElement);
        return this;
    }

    public RandomIdConfig addAllCharacterElement(List<RandomSeedElement> randomSeedElements) {
        this.randomSeedElements.addAll(randomSeedElements);
        return this;
    }

    public RandomIdConfig insertCharacterElement(int index, RandomSeedElement randomSeedElement) {
        this.randomSeedElements.add(index, randomSeedElement);
        return this;
    }

    public RandomIdConfig replaceCharacterElement(RandomSeedElement oldRandomSeedElement, RandomSeedElement newRandomSeedElement) {
        int index = this.randomSeedElements.indexOf(oldRandomSeedElement);
        if (index != -1) {
            this.randomSeedElements.remove(index);
            this.randomSeedElements.add(index, newRandomSeedElement);
        }
        return this;
    }

    public RandomIdConfig removeCharacterElement(RandomSeedElement randomSeedElement) {
        this.randomSeedElements.remove(randomSeedElement);
        return this;
    }

    public RandomIdConfig removeAllCharacterElement() {
        this.randomSeedElements.clear();
        return this;
    }
}
