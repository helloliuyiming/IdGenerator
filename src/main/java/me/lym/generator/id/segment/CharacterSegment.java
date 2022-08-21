package me.lym.generator.id.segment;

public class CharacterSegment implements Segment{

    public String character = "";

    public CharacterSegment(String characters) {
        this.character = characters;
    }

    @Override
    public String generate() {
        return character;
    }
}
