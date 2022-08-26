package me.lym.generator.id.segment;

import me.lym.generator.id.segment.seqelement.SeqElement;
import me.lym.generator.id.segment.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractSeqElement implements SeqElement {

    private int minLength;
    private int maxLength;
    private String value;
    private char placeholder;
    private List<OnValueChangeListener> onValueChangeListeners;
    private SequenceSegmentContext sequenceSegmentContext;
    public AbstractSeqElement() {
        onValueChangeListeners = new ArrayList<>();
    }

    @Override
    public void init(SequenceSegmentContext context) {
        this.sequenceSegmentContext = context;
    }

    @Override
    public SequenceSegmentContext getContext() {
        return this.sequenceSegmentContext;
    }

    @Override
    public int getMaxLength() {
        return this.maxLength;
    }

    @Override
    public int getMinLength() {
        return this.minLength;
    }

    @Override
    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder(getRealValue());
        if (stringBuilder.length() < getMinLength()) {
            int space = getMinLength() - stringBuilder.length();
            for (int i = 0; i < space; i++) {
                stringBuilder.insert(0,getPlaceholder());
            }
        }
        return stringBuilder.toString();
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void setValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value can't be null");
        }
        int index = 0;
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == getPlaceholder()) {
                index++;
            }
        }
        this.value = value.substring(index);
        publishNewValue(this.value,value);
    }

    @Override
    public char getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(char placeholder) {
        this.placeholder = placeholder;
    }

    public String getRealValue(){
        return this.value;
    }

    @Override
    public void registerListener(OnValueChangeListener onValueChangeListener) {
        this.onValueChangeListeners.add(onValueChangeListener);
    }

    public void publishNewValue(String oldValue, String newValue) {
        if (!onValueChangeListeners.isEmpty() && !Objects.equals(oldValue,newValue)) {
            onValueChangeListeners.forEach(onValueChangeListener -> onValueChangeListener.onValueChange(oldValue,newValue));
        }
    }
}
