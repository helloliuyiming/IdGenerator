package me.lym.generator.id.segment.store;

public class InMemoryStore implements Store{

    private String value;

    public InMemoryStore(){
        System.out.println("InMemoryStore constructor");
    }

    @Override
    public void setValue(String value) {
        System.out.println("setValue");
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
