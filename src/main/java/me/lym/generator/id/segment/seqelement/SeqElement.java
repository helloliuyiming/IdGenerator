package me.lym.generator.id.segment.seqelement;

import me.lym.generator.id.segment.OnValueChangeListener;
import me.lym.generator.id.segment.SequenceSegmentContext;

public interface SeqElement {

    int getMaxLength();
    int getMinLength();
    char getPlaceholder();
    String increase();
    String getValue();
    void setValue(String value);
    void reset();

    void init(SequenceSegmentContext context);
    SequenceSegmentContext getContext();
    void registerListener(OnValueChangeListener onValueChangeListener);
}
