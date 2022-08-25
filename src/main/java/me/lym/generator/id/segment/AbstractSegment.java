package me.lym.generator.id.segment;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSegment implements Segment {
    private SegmentIdGeneratorContext context;
    private List<OnValueChangeListener> onValueChangeListeners;

    public AbstractSegment(){
        onValueChangeListeners = new LinkedList<>();
    }

    @Override
    public void init(SegmentIdGeneratorContext context) {
        this.context = context;
    }

    @Override
    public SegmentIdGeneratorContext getContext() {
        return context;
    }

    void publishNewValue(String oldValue, String newValue) {
        if (!onValueChangeListeners.isEmpty()) {
            onValueChangeListeners.forEach(onValueChangeListener -> onValueChangeListener.onValueChange(oldValue,newValue));
        }
    }

    @Override
    public void registerListener(OnValueChangeListener onValueChangeListener) {
        onValueChangeListeners.add(onValueChangeListener);
    }
}
