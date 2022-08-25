package me.lym.generator.id.segment;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSegment implements Segment {
    private SequenceSegmentContext context;
    private List<OnValueChangeListener> onValueChangeListeners;

    public AbstractSegment(){
        onValueChangeListeners = new LinkedList<>();
    }
}
