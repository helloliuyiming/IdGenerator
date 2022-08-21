package me.lym.generator.id.random;

import me.lym.generator.id.random.element.CharacterElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RandomIdConfig {

    private Integer maxLength = 12;
    private Integer minLength = 12;
    private List<CharacterElement> characterElements;

    public RandomIdConfig(){
        characterElements = new ArrayList<>();
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

    public List<CharacterElement> getCharacterElements(){
        return this.characterElements;
    }

    public RandomIdConfig addCharacterElement(CharacterElement characterElement) {
        this.characterElements.add(characterElement);
        return this;
    }

    public RandomIdConfig addAllCharacterElement(List<CharacterElement> characterElements) {
        this.characterElements.addAll(characterElements);
        return this;
    }

    public RandomIdConfig insertCharacterElement(int index,CharacterElement characterElement) {
        this.characterElements.add(index, characterElement);
        return this;
    }

    public RandomIdConfig replaceCharacterElement(CharacterElement oldCharacterElement, CharacterElement newCharacterElement) {
        int index = this.characterElements.indexOf(oldCharacterElement);
        if (index != -1) {
            this.characterElements.remove(index);
            this.characterElements.add(index,newCharacterElement);
        }
        return this;
    }

    public RandomIdConfig removeCharacterElement(CharacterElement characterElement) {
        this.characterElements.remove(characterElement);
        return this;
    }

    public RandomIdConfig removeAllCharacterElement() {
        this.characterElements.clear();
        return this;
    }
}
