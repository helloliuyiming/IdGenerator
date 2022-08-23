package me.lym.generator.id.segment;

public interface SeqElement {

    int getMaxLength();
    int getMinLength();
    char getPlaceholder();
    String increase();
    String getValue();
    String getOriginValue();
    void reset();
    String getKey();
}
