package me.lym.generator.id.segment;

import me.lym.generator.id.segment.store.InMemoryStore;
import me.lym.generator.id.segment.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractSeqElement implements SeqElement {

    private int minLength;
    private int maxLength;
    private String value;
    private String originValue = "";
    private char placeholder;
    private String key;
    private Store store;
    private List<OnValueChangeListener> onValueChangeListeners;
    private SequenceSegmentContext sequenceSegmentContext;
    public AbstractSeqElement(String key) {
        this.key = key;
        onValueChangeListeners = new ArrayList<>();
    }

    @Override
    public void init(SequenceSegmentContext context) {
        this.sequenceSegmentContext = context;
        if (store == null) {
            store = new InMemoryStore();
        }
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
    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        if (store == null) {
            throw new IllegalArgumentException("store can't be null");
        }
        this.store = store;
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

    @Override
    public String getOriginValue() {
        return this.originValue;
    }

    @Override
    public void reset() {
        this.value = originValue;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value can't be null");
        }
        publishNewValue(this.value,value);
        this.value = value;
    }

    public void setOriginValue(String originValue) {
        this.originValue = originValue;
    }

    @Override
    public char getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(char placeholder) {
        this.placeholder = placeholder;
    }

    public String getRealValue(){
        if (this.value == null) {
            this.value = originValue;
        }
        return this.value;
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
