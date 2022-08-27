package me.lym.generator.id.segment.seqelement;

public class LowerCaseSeqElement extends AbstractSeqElement implements SeqElementStorable{

    private String key;

    public LowerCaseSeqElement(String key,int minLength,int maxLength,char placeholder) {
        this.key = key;
        setMinLength(minLength);
        setMaxLength(maxLength);
        setPlaceholder(placeholder);
    }

    @Override
    public String increase() {
        char[] chars = getRealValue().toCharArray();
        StringBuilder stringBuilder = new StringBuilder(chars.length + 1);
        boolean increaseDone = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            int ascii = (int) c;
            if ((ascii < 97 || ascii > 122)) {
                throw new IllegalStateException();
            }
            if (increaseDone) {
                stringBuilder.insert(0,c);
                continue;
            }
            if (ascii < 122) {
                ascii++;
                c = (char) ascii;
                stringBuilder.insert(0,c);
                increaseDone = true;
                continue;
            }
            stringBuilder.insert(0, 'a');
        }
        if (!increaseDone) {
            if (chars.length < getMaxLength()) {
                stringBuilder.insert(0, 'a');
            }else {
                return null;
            }
        }
        setValue(stringBuilder.toString());
        return getValue();
    }

    @Override
    public void reset() {
        setValue("");
    }

    @Override
    public String getKey() {
        return key;
    }
}
