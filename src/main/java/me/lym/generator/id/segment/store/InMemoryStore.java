package me.lym.generator.id.segment.store;

public class InMemoryStore implements Store{

    private String value;

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
