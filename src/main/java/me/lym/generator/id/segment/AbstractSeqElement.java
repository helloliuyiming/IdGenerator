package me.lym.generator.id.segment;

public abstract class AbstractSeqElement implements SeqElement {

    private int minLength;
    private int maxLength;
    private String value;
    private String originValue;
    private char placeholder;
    private String key;

    public AbstractSeqElement(String key) {
        this.key = key;
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
        StringBuilder stringBuilder = new StringBuilder(this.value);
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
        return this.value;
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
