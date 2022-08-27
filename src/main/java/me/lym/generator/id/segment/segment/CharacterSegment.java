package me.lym.generator.id.segment.segment;

import me.lym.generator.id.segment.AbstractSegment;

public class CharacterSegment extends AbstractSegment {

    public String character = "";

    public CharacterSegment(String characters) {
        this.character = characters;
    }

    @Override
    public String generate() {
        return character;
    }
}
