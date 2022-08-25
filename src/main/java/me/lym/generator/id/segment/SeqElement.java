package me.lym.generator.id.segment;

import me.lym.generator.id.segment.store.Store;

public interface SeqElement {

    int getMaxLength();
    int getMinLength();
    char getPlaceholder();
    String increase();
    String getValue();
    String getOriginValue();
    void reset();
    String getKey();
    Store getStore();

    void init(SequenceSegmentContext context);
    SequenceSegmentContext getContext();
    void registerListener(OnValueChangeListener onValueChangeListener);
}
